package com.soat.javaee7.websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.websocket.ClientEndpointConfig;
import javax.websocket.ContainerProvider;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *  Tests the Websocket Endpoint that sends a binary message
 *
 * @author Julien Sadaoui
 */
public class BinaryTest extends AbstractWebsocketTest
{    
    
    @Test
    public void testBinaryUsingAnnotations() throws Exception {
        testBinaryEndPoint("/websocket-binary", "Sends a binary message", "Sends a binary message (from your server).");
    }
    
    @Test
    public void testBinaryUsingProgrammatic() throws Exception {
        testBinaryEndPoint("/websocket-binary-programmatic", "Sends a binary message", "Sends a binary message (from your server using programmatic).");
    }
    
    
    /**
     *  Sends the binary message with a programmatic client endpoint.
     */
    public void testBinaryEndPoint(final String path, final String message, final String expected) 
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
                    session.getBasicRemote().sendBinary(ByteBuffer.wrap(message.getBytes()));
                } catch (IOException ex) {}
                
            }
        }, ClientEndpointConfig.Builder.create().build(), getURI(path));
                

        // wait the received message
        countMessage.await(1, TimeUnit.SECONDS);
        assertEquals("Number of received messages is not 0.", 0, countMessage.getCount());
    }
}
