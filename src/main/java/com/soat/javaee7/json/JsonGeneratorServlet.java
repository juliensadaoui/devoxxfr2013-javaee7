package com.soat.javaee7.json;

import com.soat.javaee7.servlet.CommonHttpServlet;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  An simple usage of Json Generator (Streaming APIs)
 *  JsonGenerator - Streaming JSON generator
 *
 * @author Julien Sadaoui
 */
@WebServlet(urlPatterns = {"/json-generator"})
public class JsonGeneratorServlet extends CommonHttpServlet {

    private static final String TITLE = "An sample usage of JsonBuilder (Streaming APIs)";
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException
    {
            StringBuilder content = new StringBuilder();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            
            // part 1 : build a simple object
            example1(baos);
            content.append("Example 1 : Writes a simple object in a streaming way<br />");
            content.append("<pre><code>");
            content.append(baos.toString());
            content.append("</code></pre>");

            // part 2 : build a object with array
            example2(baos);
            content.append("Example 2 : Writes a simple object with array in a streaming way<br />");
            content.append("<pre><code>");
            content.append(baos.toString());
            content.append("</code></pre>");
            
            // part 3 : build a object with array and embedded object
            example2(baos);
            content.append("Example 3 : Writes a simple object with array and embedded object in a streaming way<br />");
            content.append("<pre><code>");
            content.append(baos.toString());
            content.append("</code></pre>");
            
            this.display(request, response, TITLE, content.toString());    
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return TITLE;
    }
        
    /**
     *  Writes a simple object in a streaming way
     * 
     * @param out   output stream of byte
     */
    public void example1(OutputStream out) {
        
        Json.createGenerator(out)
                .writeStartObject()
                    .write("firstName", "John")
                    .write("lastName", "Smith")
                    .write("age", 25)
                .writeEnd()
            .close();
    } 
    
    /**
     *  Writes a simple object with array in a streaming way
     * 
     * @param out   output stream of byte
     */
    public void example2(OutputStream out) {
        
        Json.createGenerator(out)
                .writeStartObject()
                    .write("firstName", "John")
                    .write("lastName", "Smith")
                    .write("age", 28)
                    .writeStartArray("phoneNumber")
                        .writeStartObject()
                            .write("type", "home")
                            .write("number", "212 555-1234")
                        .writeEnd()
                        .writeStartObject()
                            .write("type", "fax")
                            .write("number", "646 555-4567")
                        .writeEnd()
                    .writeEnd()
                .writeEnd()
            .close();
    } 

    /**
     *  Writes a simple object with array and embedded object in a streaming way
     * 
     * @param out   output stream of byte
     */
    public void example3(OutputStream out) {
        
        Json.createGenerator(out)
                .writeStartObject()
                    .write("firstName", "John")
                    .write("lastName", "Smith")
                    .write("age", 28)
                    .writeStartObject("address")
                        .write("streetAddress", "21 2nd Street")
                        .write("city", "New York")
                        .write("state", "NY")
                        .write("postalCode", "10021")
                    .writeEnd()
                    .writeStartArray("phoneNumber")
                        .writeStartObject()
                            .write("type", "home")
                            .write("number", "212 555-1234")
                        .writeEnd()
                        .writeStartObject()
                            .write("type", "fax")
                            .write("number", "646 555-4567")
                        .writeEnd()
                    .writeEnd()
                .writeEnd()
            .close();
    }


}
