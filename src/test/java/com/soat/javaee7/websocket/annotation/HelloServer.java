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
import  com.soat.javaee7.websocket.annotation.HelloServer.MyEndPoint;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author 912580
 */
public class HelloServer {

    public static final String HOST_NAME = "localhost";
    public static final int    PORT      = 8025;
    public static final String ROOT_PATH = "/javaee7";
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    public Server startServer (String host, int port, String rootPath, Class<?>[] configuration)
        throws DeploymentException
    {
        final Server server = new Server(host, port, rootPath, configuration);
        server.start();
        return server;
    }
   
    public Server startServer(Class<?> configuration) throws DeploymentException {
        return startServer(HOST_NAME, PORT, ROOT_PATH, new Class[]{ configuration });
    }
    
    public void stopServer (Server server) {
        if (server != null) server.stop();
    }
    

    
   
    @Test
    public void testHello () throws DeploymentException {
     // https://blogs.oracle.com/arungupta/entry/websocket_client_and_server_endpoint
        // http://java.net/projects/tyrus/sources/source-code-repository/content/trunk/samples/echo/src/test/java/org/glassfish/tyrus/sample/echo/EchoTest.java?rev=607
        
        Server server = startServer(MyServerConf.class);
        
        try {
       final WebSocketContainer container = ContainerProvider.getWebSocketContainer();


        MyEndPoint endPoint = new MyEndPoint();
        final Session session = container.connectToServer(endPoint, ClientEndpointConfig.Builder.create().build(), new URI("ws://localhost:8025/javaee7/websocket-programmatic-hello"));
        
        session.getBasicRemote().sendText("blbla");

        System.out.println(endPoint.getMessage());
        } 
        catch (URISyntaxException | DeploymentException | IOException e) {
            Logger.getLogger(HelloServer.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        finally {
            stopServer(server);
        }
        
    }
    
    class MyEndPoint extends Endpoint {

        private String message;
        
        @Override
        public void onOpen(Session session, EndpointConfig endPointConfig) 
        {
            session.addMessageHandler(new MessageHandler.Whole<String>() {

                @Override
                public void onMessage(String text) {
                    message = text;
                }
            });
        }
           
        public String getMessage() {
            return message;
        }
    }

}
