package com.soat.javaee7.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julien Sadaoui
 */
public abstract class CommonHttpServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected abstract void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * 
     * @param request
     * @param response
     * @param title
     * @param content
     * @throws ServletException
     * @throws IOException 
     */
    protected void display(HttpServletRequest request, HttpServletResponse response,
                            String title, String content) throws ServletException, IOException {
        
        request.setAttribute("title", title);
        request.setAttribute("servletName", this.getServletName());
        request.setAttribute("contextPath", request.getContextPath());
        request.setAttribute("content", content);
        this.getServletContext().getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
    }
}
