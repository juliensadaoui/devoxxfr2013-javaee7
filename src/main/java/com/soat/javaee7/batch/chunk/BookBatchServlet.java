/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.batch.chunk;

import com.soat.javaee7.servlet.CommonHttpServlet;
import java.io.IOException;
import java.util.Properties;
import javax.batch.operations.JobOperator;
import javax.batch.operations.JobSecurityException;
import javax.batch.operations.JobStartException;
import javax.batch.operations.NoSuchJobExecutionException;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juliens Sadaoui
 */
@WebServlet(urlPatterns = {"/batch-chunk"})
public class BookBatchServlet extends CommonHttpServlet
{
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        try {
            long id = jobOperator.start("bookJob", new Properties());
            JobExecution execution = jobOperator.getJobExecution(id);

        } catch (JobStartException | JobSecurityException | NoSuchJobExecutionException ex) {
            throw new ServletException(ex.getMessage(), ex);
        } 

    }
}
