package com.soat.javaee7.websocket;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.websocket.ClientEndpointConfig;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import org.glassfish.tyrus.server.Server;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;


public abstract class AbstractWebsocketTest
{
    public static final String HOST_NAME = "localhost";
    public static final int    PORT      = 8025;
    public static final String ROOT_PATH = "/javaee7";
    
    // embedded server (tyrus)
    private static Server server;
    
    /**
     *  Start a embedded server
     * 
     * @throws DeploymentException 
     */
    @Before
    public void setUp() throws DeploymentException {
        server = new Server(HOST_NAME,PORT,ROOT_PATH, WebsocketServerApplicationConfig.class);
        server.start();
    }
    
    @After
    public void tearDown() {
        if (server != null) server.stop();
    }
       
    /**
     *  Constructs a URI with the given path
     * 
     * @param path
     * @return URI
     * @throws URISyntaxException 
     */
    public URI getURI(String path) throws URISyntaxException {
        return new URI("ws", null, HOST_NAME, PORT, ROOT_PATH + path, null, null);
    } 
    
    /**
     *  Sends a text message with a programmatic client endpoint.
     */
    public void shouldSendTextMessage(final String path, final String name, final String expected) 
        throws Exception
    {
        final CountDownLatch countMessage = new CountDownLatch(1);
        
        // create a programmatic client endpoint
        ContainerProvider.getWebSocketContainer().connectToServer(new Endpoint() {
            
            @Override
            public void onOpen(Session session, EndpointConfig config) {
                 
                session.addMessageHandler(new MessageHandler.Whole<String>() {

                    @Override
                    public void onMessage(String message) {
                        if (message.equals(expected))
                            countMessage.countDown();
                    }
                });
                
                // send the message to the server
                try { session.getBasicRemote().sendText(name);
                } catch (IOException ex) {}
            }
        }, ClientEndpointConfig.Builder.create().build(), getURI(path));
             
        // wait the received message
        countMessage.await(1, TimeUnit.SECONDS);
        assertEquals("Number of received messages is not 0.", 0, countMessage.getCount());
    }
    
    /**
     *  Sends a binary message with a programmatic client endpoint.
     */
    public void shouldSendBinaryMessage(final String path, final ByteBuffer binary, final String expected) 
        throws Exception
    {
        final CountDownLatch countMessage = new CountDownLatch(1);
        
        // create a programmatic client endpoint
        ContainerProvider.getWebSocketContainer().connectToServer(new Endpoint() {

            @Override
            public void onOpen(Session session, EndpointConfig config) {
                
                session.addMessageHandler(new MessageHandler.Whole<ByteBuffer>() {

                    @Override
                    public void onMessage(ByteBuffer byteBuffer) {
                        
                        final byte[] bytes = new byte[byteBuffer.remaining()];
                        byteBuffer.duplicate().get(bytes);
                        String message = new String(bytes);

                        if (message.toString().equals(expected))
                            countMessage.countDown();
                    }
                });
                try {
                    session.getBasicRemote().sendBinary(binary);
                } catch (IOException ex) {}
                
            }
        }, ClientEndpointConfig.Builder.create().build(), getURI(path));
                

        // wait the received message
        countMessage.await(1, TimeUnit.SECONDS);
        assertEquals("Number of received messages is not 0.", 0, countMessage.getCount());
    }
}
