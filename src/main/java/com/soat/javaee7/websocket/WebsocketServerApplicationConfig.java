package com.soat.javaee7.websocket;

import com.soat.javaee7.websocket.binary.EchoBinaryBean;
import com.soat.javaee7.websocket.binary.EchoBinaryEndPoint;
import com.soat.javaee7.websocket.chat.ChatBean;
import com.soat.javaee7.websocket.encoder.BookBean;
import com.soat.javaee7.websocket.hello.HelloTextEndPoint;
import com.soat.javaee7.websocket.hello.HelloTextBean;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

/**
 *  TODO add comments
 *
 * @author Julien Sadaoui
 */
public class WebsocketServerApplicationConfig implements ServerApplicationConfig {

    /**
     *  Add the Web Socket EndPoint using programmatic 
     */
    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> set) {
        return new HashSet<ServerEndpointConfig>() {{
            add(ServerEndpointConfig.Builder.create(HelloTextEndPoint.class, "/websocket-hello-programmatic").build());
            add(ServerEndpointConfig.Builder.create(EchoBinaryEndPoint.class, "/websocket-binary-programmatic").build());
        }};
    }

    /**
     *  Add the Web Socket EndPoint using annotations
     */
    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> set) {
        return new HashSet<Class<?>>() {{
            add(HelloTextBean.class);
            add(EchoBinaryBean.class);
            add(BookBean.class);
            add(ChatBean.class);
        }};
    }
    
}
