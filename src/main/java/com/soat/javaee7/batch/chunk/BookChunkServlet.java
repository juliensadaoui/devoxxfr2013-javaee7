package com.soat.javaee7.batch.chunk;

import com.soat.javaee7.servlet.CommonHttpServlet;
import java.io.IOException;
import java.util.Properties;
import javax.batch.operations.JobOperator;
import javax.batch.operations.JobSecurityException;
import javax.batch.operations.JobStartException;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.batch.runtime.StepExecution;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juliens Sadaoui
 */
@WebServlet(urlPatterns = {"/batch-chunk"})
public class BookChunkServlet extends CommonHttpServlet
{
    private static final String TITLE = "An sample usage of Chunk batch";
        
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        StringBuilder content = new StringBuilder();
        
        try {
            
            JobOperator jobOperator = BatchRuntime.getJobOperator();

            content.append("About to start the job<br/>");
            content.append("Got the job operator: ");
            content.append(jobOperator);
            long id = jobOperator.start("bookJob", new Properties());
            JobExecution execution = jobOperator.getJobExecution(id);
            content.append("Got the job execution: ");
            content.append(execution);
            content.append("Job submitted<br />");
            content.append("Check server.log for output from the task.");
        
        
//            JobExecution execution = jobOperator.getJobExecution(id);
            
        } catch (Exception e) {
            throw new ServletException(e.getMessage(), e);
        }

        this.display(request, response, TITLE, content.toString());  
    }
}
