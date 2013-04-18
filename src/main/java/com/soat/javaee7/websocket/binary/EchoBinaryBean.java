package com.soat.javaee7.websocket.binary;

import java.nio.ByteBuffer;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 *  A example of End point that sends a binary message to the sender
 *  Implementing Web Socket EndPoint using annotations
 * 
 * @author Julien Sadaoui
 */
@ServerEndpoint("/websocket-binary")
public class EchoBinaryBean {
        
    @OnMessage
    public ByteBuffer echo(ByteBuffer byteBuffer) {
        
        // transform the "ByteBuffer" message
        final byte[] bytes = new byte[byteBuffer.remaining()];
        byteBuffer.duplicate().get(bytes);
        String message = new String(bytes);
        
        // send the updated message 
        message += " (from your server).";
        return ByteBuffer.wrap(message.getBytes());        
    }
    
}
