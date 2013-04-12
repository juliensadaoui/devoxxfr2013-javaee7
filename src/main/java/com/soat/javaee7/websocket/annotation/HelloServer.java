/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.websocket.annotation;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 *  A example of a simple endpoint that displays any text message to the sender. 
 *  Implementing Web Socket EndPoint using annotations
 * 
 * @author Julien Sadaoui
 */
@ServerEndpoint("/websocket/annotations/hello")
public class HelloServer {
    
    @OnMessage
    public String getMessage(String name) {
        return "Hello " + name;
    }
}
