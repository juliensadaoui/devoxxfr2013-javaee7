/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.websocket.annotation;

import com.soat.javaee7.websocket.programmatic.MyServerConf;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.websocket.ClientEndpointConfig;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import org.glassfish.tyrus.server.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author 
 */
public class HelloServerTest {

    public static final String HOST_NAME = "localhost";
    public static final int    PORT      = 8025;
    public static final String ROOT_PATH = "/javaee7";
    
    private Server server;
    
    @Before
    public void setUp() throws DeploymentException {
        server = new Server(HOST_NAME,PORT,ROOT_PATH, MyServerConf.class);
        server.start();
    }
    
    @After
    public void tearDown() {
        if (server != null) server.stop();
    }
       
    public URI getURI(String path) throws URISyntaxException {
        return new URI("ws", null, HOST_NAME, PORT, ROOT_PATH + path, null, null);
    } 
    
    @Test
    public void testHelloOK() throws Exception {
        testHello("/websocket-programmatic-hello", "java","Hellojava");
    }

    @Test(expected = AssertionError.class)
    public void testHelloFail() throws Exception {
        testHello("/websocket-programmatic-hello", "java","Hello");
    }
    
    public void testHello (final String path, final String name, final String expected) throws Exception {
     // https://blogs.oracle.com/arungupta/entry/websocket_client_and_server_endpoint
        // http://java.net/projects/tyrus/sources/source-code-repository/content/trunk/samples/echo/src/test/java/org/glassfish/tyrus/sample/echo/EchoTest.java?rev=607
        
        final CountDownLatch countMessage = new CountDownLatch(1);

        ContainerProvider.getWebSocketContainer().connectToServer(new Endpoint() {
            
            @Override
            public void onOpen(Session session, EndpointConfig ec) {
                 
                session.addMessageHandler(new MessageHandler.Whole<String>() {

                    @Override
                    public void onMessage(String message) {

                        if (message.equals(expected)) {
                            countMessage.countDown();
                        }
                    }
                });
                try {
                    session.getBasicRemote().sendText(name);
                } catch (IOException ex) {
                }
            }
        }, ClientEndpointConfig.Builder.create().build(), getURI(path));
             
        
        countMessage.await(1, TimeUnit.SECONDS);
        assertEquals("Number of received messages is not 0.", 0, countMessage.getCount());
    }
}
