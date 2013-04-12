/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.websocket.annotation;

import com.soat.javaee7.websocket.programmatic.MyServerConf;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.ClientEndpointConfig;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import org.glassfish.tyrus.client.ClientManager;
import org.glassfish.tyrus.server.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 912580
 */
public class HelloServer {

    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
   
    @Test
    public void testHello () throws DeploymentException {
        final Server server = new Server("localhost", 8025, "/javaee7", MyServerConf.class);
        server.start();
     
        try {
        final ClientManager client = ClientManager.createClient();
        final Session session = client.connectToServer(new Endpoint() {
            
            @Override
            public void onOpen(Session session, EndpointConfig config) {
                try {
                    session.addMessageHandler(new MessageHandler.Whole<String>() {

                        @Override
                        public void onMessage(String message) {
                            System.out.println(message);
                            assertEquals("jkj", "jh");
                            throw new RuntimeException();
                        }
                    });
                    
                    session.getBasicRemote().sendText("blbla");
                    
                } catch (IOException ex) {
                    Logger.getLogger(HelloServer.class.getName()).log(Level.SEVERE, null, ex);
                                ex.printStackTrace();
                }
                
            }
        }, ClientEndpointConfig.Builder.create().build(), new URI("ws://localhost:8025/javaee7/websocket-programmatic-hello"));
        } 
        catch (Exception e) {
            Logger.getLogger(HelloServer.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        finally {
            server.stop();
        }
        
        
    }

}
