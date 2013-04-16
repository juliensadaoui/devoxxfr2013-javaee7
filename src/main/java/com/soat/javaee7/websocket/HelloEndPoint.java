package com.soat.javaee7.websocket;

import java.io.IOException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;

/**
 *  A example of a simple endpoint that displays a "hello" message to the sender. 
 *  Implementing Web Socket EndPoint using programmatic
 * 
 * @author Julien Sadaoui
 */
public class HelloEndPoint extends Endpoint {

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        
        final RemoteEndpoint.Basic remote = session.getBasicRemote();
        
        session.addMessageHandler(new MessageHandler.Whole<String>() {
             
             @Override
             public void onMessage(String name) {
                 try {
                     remote.sendText("Hello " + name + " (from your server).");
                 } catch (IOException ioe) {}
             }
         });
    }

}
