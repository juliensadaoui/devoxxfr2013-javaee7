/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;

/**
 *  A example of End point that sends a binary message to the sender
 *  Implementing Web Socket EndPoint using programmatic
 *
 * @author Julien Sadaoui
 */
public class BinaryEndPoint extends Endpoint
{

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        
        final RemoteEndpoint.Basic remote = session.getBasicRemote();
        
        session.addMessageHandler(new MessageHandler.Whole<ByteBuffer>() {

            @Override
            public void onMessage(ByteBuffer byteBuffer) {

                // transform the "ByteBuffer" message
                final byte[] bytes = new byte[byteBuffer.remaining()];
                byteBuffer.duplicate().get(bytes);
                String message = new String(bytes);

                // send the updated message 
                message += " (from your server using programmatic).";
                try {
                    remote.sendBinary(ByteBuffer.wrap(message.getBytes()));
                } catch (IOException ex) {}
            }
        });
    }
    
}
