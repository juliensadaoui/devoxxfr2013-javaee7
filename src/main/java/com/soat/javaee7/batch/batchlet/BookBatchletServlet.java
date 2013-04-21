package com.soat.javaee7.batch.batchlet;

import com.soat.javaee7.servlet.CommonHttpServlet;
import java.io.IOException;
import javax.jws.WebService;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
