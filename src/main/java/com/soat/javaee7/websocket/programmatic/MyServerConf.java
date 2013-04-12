/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.websocket.programmatic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

/**
 *
 * @author Julien Sadaoui
 */
public class MyServerConf implements ServerApplicationConfig {

    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> set) {
        return new HashSet<ServerEndpointConfig>() {{
            add(ServerEndpointConfig.Builder.create(HelloServer.class, "/websocket-programmatic-hello").build());
        }};
    }

    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> set) {
        return Collections.emptySet();
    }
    
}
