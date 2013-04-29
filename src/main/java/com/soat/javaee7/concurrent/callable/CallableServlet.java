package com.soat.javaee7.concurrent.callable;

import com.soat.javaee7.concurrent.Book;
import com.soat.javaee7.servlet.CommonHttpServlet;
import java.io.IOException;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julien Sadaoui
 */
@WebServlet(name = "/concurrency-callable")
public class CallableServlet extends CommonHttpServlet
{
    
    
    @Resource(name="concurrent/BatchExecutor")
    ManagedExecutorService executor;
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Future<Book> f = executor.submit(new CallableTask());
  
        while (f.isDone()) {

        }
//        executor.execute(null);
        this.display(request, response, "Test JSR 266", "");  
        
    }
    
}
