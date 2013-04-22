/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.websocket.chat;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * This end point represents a simple chat based on WebSocket 
 *
 * @author Julien Sadaoui
 */
@ServerEndpoint("/websocket-chat")
public class ChatBean
{
    Set<Session> peers = new HashSet<>();
    
    @OnOpen
    public void onOpen(Session peer) {
        peers.add(peer);
    }
    
    /**
     * The end point sends that message to all conected users 
     * 
     * @param message
     * @throws IOException 
     */
    @OnMessage
    public void message(String message) throws IOException {
        for (Session peer : peers) {
            peer.getBasicRemote().sendText(message);
        }
    }
    
    @OnClose
    public void onClose(Session peer) {
        peers.remove(peer);
    }
}
