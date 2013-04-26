package com.soat.javaee7.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Julien Sadaoui
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(com.soat.javaee7.rest.BookRestService.class);
        return resources;
    }
}
