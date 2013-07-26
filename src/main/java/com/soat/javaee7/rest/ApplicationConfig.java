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

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically re-generated by NetBeans REST support to populate
     * given list with all resources defined in the project.
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.soat.javaee7.rest.BookRestService.class);
    }
}
