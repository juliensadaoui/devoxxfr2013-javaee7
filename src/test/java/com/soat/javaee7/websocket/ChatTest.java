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
 *  Test the simple chat based on the websocket
 *
 * @author Julien Sadaoui
 */
public class ChatTest extends AbstractWebsocketTest
{
    private static final String MESSAGE = "This message is sent from a client end point";

    @Test
    public void testChatEndPoint() 
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
                        if (message.equals(MESSAGE))
                            countMessage.countDown();
                    }
                });
                
                // send the message to the server
                try { session.getBasicRemote().sendText(MESSAGE);
                } catch (IOException ex) {}
            }
        }, ClientEndpointConfig.Builder.create().build(), getURI("/websocket-chat"));
             
        // wait the received message
        countMessage.await(1, TimeUnit.SECONDS);
        assertEquals("Number of received messages is not 0.", 0, countMessage.getCount());
    }
}
