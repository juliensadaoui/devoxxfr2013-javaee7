package com.soat.javaee7.websocket;

import java.nio.ByteBuffer;
import org.junit.Test;

/**
 *  Tests the Websocket Endpoint that sends a binary message
 *
 * @author Julien Sadaoui
 */
public class BinaryTest extends AbstractWebsocketTest
{    
    private static final String MESSAGE = "Sends a binary message";
    
    @Test
    public void testBinaryUsingAnnotations() throws Exception {
        
        shouldSendBinaryMessage("/websocket-binary", ByteBuffer.wrap(MESSAGE.getBytes()), "Sends a binary message (from your server).");
    }
    
    @Test
    public void testBinaryUsingProgrammatic() throws Exception {
        shouldSendBinaryMessage("/websocket-binary-programmatic", ByteBuffer.wrap(MESSAGE.getBytes()), "Sends a binary message (from your server using programmatic).");
    }
    
    

}
