package com.soat.javaee7.concurrent.runnable;

import com.soat.javaee7.servlet.CommonHttpServlet;
import java.io.IOException;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  see https://blogs.oracle.com/arungupta/entry/concurrency_utilities_for_java_ee
 *  see http://branchandbound.net/blog/java/2012/07/modern-concurrency-and-javaee/
 *  see http://zenika.developpez.com/articles/java/core/javaprogconcurrente/
 * 
 *  A servlet that executes a runnable task using JSR 236 (Concurrency Utilities for Java EE) 
 * 
 * @author Julien Sadaoui
 */
@WebServlet(urlPatterns = {"/concurrency-runnable"})
public class RunnableServlet extends CommonHttpServlet
{
    private static final String TITLE = "Execute a runnable task using JSR 236.";
    
    // inject the JNDI references
    @Resource(name="concurrent/BatchExecutor")
    ManagedExecutorService executor;
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        StringBuilder content = new StringBuilder();
        
        Runnable task = new RunnableTask();
        
        // This task is executed to the executor using the execute method
        executor.execute(task);
        content.append("Description:<br />"); 
        content.append("This task print the first 10 Fibonacci numbers to the console.<br />");
        
        this.display(request, response, TITLE, content.toString());  
    }
}
