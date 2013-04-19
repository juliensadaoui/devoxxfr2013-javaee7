/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.websocket;

import java.io.IOException;
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
 *
 * @author Julien Sadaoui
 */
public class BookTest extends AbstractWebsocketTest
{
   
    private String message    = "{\"name\":\"JavaEE7\",\"description\":\"JavaEE7Platform\",\"author\":\"Oracle\"}";
    private String expected   = "{\"name\":\"UpdatedJavaEE7\",\"description\":\"UpdatedJavaEE7Platform\",\"author\":\"UpdatedOracle\"}";
    private String badMessage = "{\"name\":\"JavaEE7\",\"description\":\"JavaEE7Platform\"}";
    
    @Test
    public void testBookEncoderEndPoint() throws Exception {       
        testBookEncoderEndPoint("/websocket-encoder-book", message, expected);
    }
    
    @Test(expected = AssertionError.class)
    public void testBookEncoderEndPointWithBadMessage() throws Exception {
        testBookEncoderEndPoint("/websocket-encoder-book", badMessage, expected);
    }
    
    /**
     *  Sends the json message with a programmatic client endpoint.
     */
    public void testBookEncoderEndPoint(final String path, final String message, final String expected)
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
                        // read the json message
                        if (message.equals(expected)) {
                            countMessage.countDown();
                        }
                    }
                });
                try {
                    session.getBasicRemote().sendText(message); 
                } catch (IOException ex) {}
                
            }
        }, ClientEndpointConfig.Builder.create().build(), getURI(path));
                

        // wait the received message
        countMessage.await(1, TimeUnit.SECONDS);
        assertEquals("Number of received messages is not 0.", 0, countMessage.getCount());
    }
}
