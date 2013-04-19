package com.soat.javaee7.websocket;

import java.io.IOException;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.websocket.ClientEndpointConfig;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import org.junit.Test;
import javax.websocket.ContainerProvider;
import static org.junit.Assert.assertEquals;

/**
 *  Tests the Websocket Endpoint that displays a "hello" message to the sender. 
 * 
 * @author Julien Sadaoui
 */
public class HelloTest extends AbstractWebsocketTest
{   
    /**
     *  Test 1: end point using annotations
     */
    @Test
    public void testHelloTextUsingAnnotations() throws Exception {
        testHelloTextEndPoint("/websocket-hello", "devoxxfr2013-javaee7", "Hello devoxxfr2013-javaee7 (from your server).");
    }

    /**
     *  Test 2: end point using programmatic
     */
    @Test
    public void testHelloTextUsingProgrammatic() throws Exception {
        testHelloTextEndPoint("/websocket-hello-programmatic", "devoxxfr2013-javaee7", "Hello devoxxfr2013-javaee7 (from your server).");
    }
    
    /**
     *  Sends the "hello" message  with a programmatic client endpoint.
     */
    public void testHelloTextEndPoint(final String path, final String name, final String expected) 
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
}
