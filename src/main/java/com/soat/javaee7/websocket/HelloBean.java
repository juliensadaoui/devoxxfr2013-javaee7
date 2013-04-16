package com.soat.javaee7.websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 *  A example of a simple endpoint that displays a "hello" message to the sender. 
 *  Implementing Web Socket EndPoint using annotations
 * 
 * @author Julien Sadaoui
 */
@ServerEndpoint("/websocket-hello")
public class HelloBean {
    
    /**
     *  The "helloMessage" method is called when a message is received by this endpoint
     * 
     * @param name
     * @return message displays to the sender
     */
    @OnMessage
    public String helloMessage(String name) {
        return "Hello " + name + " (from your server).";
    }
}
