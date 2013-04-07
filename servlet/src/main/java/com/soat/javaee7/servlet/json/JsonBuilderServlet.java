/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.servlet.json;

import com.soat.javaee7.json.JsonBuilderExample;
import com.soat.javaee7.servlet.CommonHttpServlet;
import java.io.IOException;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 *  @author Julien Sadaoui
 */
@WebServlet(urlPatterns = {"/json-builder"})
public class JsonBuilderServlet extends CommonHttpServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String        title   = "An sample usage of JsonBuilder (DOM-based APIs)";
            StringBuilder content = new StringBuilder();
            
            // part 1 : build a simple object
            JsonObject simpleObject = JsonBuilderExample.buildJsonObject();
            content.append("Creating an simple object<br />");
            content.append("<pre><code>");
            content.append(simpleObject.toString());
            content.append("</code></pre>");

            // part 2 : build a object with array
            JsonObject objectWithArray = JsonBuilderExample.buildJsonObjectWithArray();
            content.append("Creating an object with array<br />");
            content.append("<pre><code>");
            content.append(objectWithArray.toString());
            content.append("</code></pre>");
            
            this.display(request, response, title, content.toString());
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "An sample usage of JsonBuilder (DOM-based APIs)";
    }
}
