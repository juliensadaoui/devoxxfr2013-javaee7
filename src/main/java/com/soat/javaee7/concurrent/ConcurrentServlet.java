package com.soat.javaee7.concurrent;

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
 * see http://zenika.developpez.com/articles/java/core/javaprogconcurrente/
 * 
 * @author Julien Sadaoui
 */
@WebServlet(urlPatterns = {"/concurrent"})
public class ConcurrentServlet extends CommonHttpServlet
{
    
    @Resource(name="concurrent/BatchExecutor")
    ManagedExecutorService executor;
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        executor.submit(new MyRunnable());
//        executor.execute(null);
        this.display(request, response, "Test JSR 266", "");  
    }
}
