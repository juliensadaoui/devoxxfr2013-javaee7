package com.soat.javaee7.concurrent.callable;

import com.soat.javaee7.concurrent.Book;
import com.soat.javaee7.servlet.CommonHttpServlet;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  A servlet that executes a callable task using JSR 236 (Concurrency Utilities for Java EE)
 *  This task that connect to Amazon Web Services and retrieve the info for the book. 
 *
 * @author Julien Sadaoui
 */
@WebServlet(urlPatterns = "/concurrency-callable")
public class CallableServlet extends CommonHttpServlet
{
    private static final String TITLE = "Execute a callable task using JSR 236.";
    
    @Resource(name="concurrent/BatchExecutor")
    ManagedExecutorService executor;
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        StringBuilder content = new StringBuilder();
        
        try {

            content.append("About to start the task:<br />"); 
            content.append("This task gets the book information from Amazon Web Services (simulate).<br /><br/>");    
            
            // This task is submitted to the executor and wait the result
            Future<Book> taskResult = executor.submit(new CallableTask());
            
            // Retrieve the book from the resulting Future list.
            Book book = taskResult.get();
            content.append("Result: <br />");
            content.append(book.toString());
            
        } catch (Exception ex) {}
        
        this.display(request, response, TITLE, content.toString());  
        
    }
    
}
