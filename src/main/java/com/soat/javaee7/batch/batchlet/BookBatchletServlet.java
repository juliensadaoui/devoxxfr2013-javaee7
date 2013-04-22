package com.soat.javaee7.batch.batchlet;

import com.soat.javaee7.servlet.CommonHttpServlet;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.batch.operations.JobOperator;
import javax.batch.operations.JobSecurityException;
import javax.batch.operations.JobStartException;
import javax.batch.runtime.BatchRuntime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julien Sadaoui
 */
@WebServlet(urlPatterns = {"/batch-batchlet"})
public class BookBatchletServlet extends CommonHttpServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
                JobOperator jobOperator = BatchRuntime.getJobOperator();
        try {
            long id = jobOperator.start("bookJobBatchlet", new Properties());
        
        //book database before process
        
        // book database after process
        } catch (JobStartException | JobSecurityException ex) {
            Logger.getLogger(BookBatchletServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
