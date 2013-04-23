package com.soat.javaee7.websocket;

import org.junit.Test;

/**
 *  Tests the Websocket Endpoint that displays a text message to the sender. 
 * 
 * @author Julien Sadaoui
 */
public class HelloTest extends AbstractWebsocketTest
{   
    /**
     *  Test 1: end point using annotations
     */
    @Test
    public void testHelloTextUsingAnnotations() throws Exception {
        shouldSendTextMessage("/websocket-hello", "devoxxfr2013-javaee7", "Hello devoxxfr2013-javaee7 (from your server).");
    }

    /**
     *  Test 2: end point using programmatic
     */
    @Test
    public void testHelloTextUsingProgrammatic() throws Exception {
        shouldSendTextMessage("/websocket-hello-programmatic", "devoxxfr2013-javaee7", "Hello devoxxfr2013-javaee7 (from your server).");
    }
    

}
