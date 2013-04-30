package com.soat.javaee7.concurrent.tasks;

import com.soat.javaee7.concurrent.Book;
import com.soat.javaee7.servlet.CommonHttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  Retrieve all books from several websites in parallel.
 *
 * @author Julien Sadaoui
 */
@WebServlet(urlPatterns = {"/concurrency-tasks"})
public class MultipleTasksServlet extends CommonHttpServlet
{
    @Resource(name="concurrent/BatchExecutor")
    ManagedExecutorService executor;
    

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        StringBuilder content = new StringBuilder();
        
        try {
            // Create a list of tasks to perform
            List<Callable<Book>> tasks = new ArrayList<>();
            tasks.add(new AmazonBookRetrieved());
            tasks.add(new PriceministerBookRetreived());
        
            // Submit the tasks to the managed executor
            List<Future<Book>> taskResults = executor.invokeAll(tasks);
            
            // Retrieve the results from the resulting Future list.
            content.append("Book from Amazon -> ");
            content.append(taskResults.get(0).get().toString());
            content.append("<br />");

            content.append("Book from Priceminister -> ");
            content.append(taskResults.get(1).get().toString());
            content.append("<br />");
        
        } catch (Exception e) {
            throw new ServletException(e.getMessage(), e);
        }

        display(request, response, "", content.toString());
    }

}
