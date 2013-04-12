/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.websocket.programmatic;

import java.io.IOException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;

/**
 *  A example of a simple endpoint that displays any text message to the sender. 
 *  Implementing Web Socket EndPoint using programmatic
 * 
 * @author Julien Sadaoui
 */
public class HelloServer extends Endpoint {

    @Override
    public void onOpen(Session session, EndpointConfig ec) {
         final RemoteEndpoint.Basic remote = session.getBasicRemote();
         session.addMessageHandler(new MessageHandler.Whole<String>() {
             public void onMessage(String text) {
                 try {
                     remote.sendText("Hello" + text);
                 } catch (IOException ioe) {
                     // handle send failure here
                 }
             }
         });
    }

}
