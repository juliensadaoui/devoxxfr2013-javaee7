package com.soat.javaee7.websocket;

import java.util.HashSet;
import java.util.Set;
import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

/**
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
            add(ServerEndpointConfig.Builder.create(HelloEndPoint.class, "/websocket-hello-programmatic").build());
            add(ServerEndpointConfig.Builder.create(BinaryEndPoint.class, "/websocket-binary-programmatic").build());
        }};
    }

    /**
     *  Add the Web Socket EndPoint using annotations
     */
    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> set) {
        return new HashSet<Class<?>>() {{
            add(HelloBean.class);
            add(BinaryBean.class);
        }};
    }
    
}
