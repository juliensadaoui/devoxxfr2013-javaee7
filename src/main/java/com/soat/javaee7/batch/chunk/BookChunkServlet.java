package com.soat.javaee7.batch.chunk;

import com.soat.javaee7.servlet.CommonHttpServlet;
import java.io.IOException;
import java.util.Properties;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet starts a simple chunk step using JSR 342.
 * 
 * @author Julien Sadaoui
 */
@WebServlet(urlPatterns = {"/batch-chunk"})
public class BookChunkServlet extends CommonHttpServlet
{
    private static final String TITLE = "An sample usage of a simple chunk step.";
        
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try 
        {
            StringBuilder content = new StringBuilder();
             
            // gets a instance of the JobOperator
            // A JobOperator can start, stop, and restart jobs
            JobOperator jobOperator = BatchRuntime.getJobOperator();
            
            // creates a job instance (for bookChunkJob) and starts a execution
            long id = jobOperator.start("bookChunkJob", new Properties());
            
            // gets the specified job execution
            JobExecution execution = jobOperator.getJobExecution(id);
            
            content.append("<h3>About to start the job</h3>");
            content.append("Job operator: ");
            content.append(jobOperator);
            content.append("<br />");
            content.append("Job execution: ");
            content.append(execution.toString());
            content.append("<br />");
            content.append("<br />");
            content.append("Check server.log for output from the chunk step.");
            
            this.display(request, response, TITLE, content.toString());  
 
        } catch (Exception e) {
            throw new ServletException(e.getMessage(), e);
        }
    }
}
