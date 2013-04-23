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
        shouldSendTextMessage("/websocket-encoder-book", message, expected);
    }
    
    @Test(expected = AssertionError.class)
    public void testBookEncoderEndPointWithBadMessage() throws Exception {
        shouldSendTextMessage("/websocket-encoder-book", badMessage, expected);
    }
}
