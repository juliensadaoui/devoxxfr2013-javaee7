package com.soat.javaee7.websocket;

import java.net.URI;
import java.net.URISyntaxException;
import javax.websocket.DeploymentException;
import org.glassfish.tyrus.server.Server;
import org.junit.After;
import org.junit.Before;


public abstract class AbstractWebsocketTest
{
    public static final String HOST_NAME = "localhost";
    public static final int    PORT      = 8025;
    public static final String ROOT_PATH = "/javaee7";
    
    // embedded server (tyrus)
    private static Server server;
    
    /**
     *  Start a embedded server
     * 
     * @throws DeploymentException 
     */
    @Before
    public void setUp() throws DeploymentException {
        server = new Server(HOST_NAME,PORT,ROOT_PATH, WebsocketServerApplicationConfig.class);
        server.start();
    }
    
    @After
    public void tearDown() {
        if (server != null) server.stop();
    }
       
    /**
     *  Constructs a URI with the given path
     * 
     * @param path
     * @return URI
     * @throws URISyntaxException 
     */
    public URI getURI(String path) throws URISyntaxException {
        return new URI("ws", null, HOST_NAME, PORT, ROOT_PATH + path, null, null);
    } 
}
