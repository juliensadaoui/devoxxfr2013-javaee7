/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.json;

import com.soat.javaee7.servlet.CommonHttpServlet;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *  An sample usage of JsonBuilder (DOM-based APIs)
 *  JsonBuilder - Builds a JSON object or JSON array 
 * 
 *  @author Julien Sadaoui
 */
@WebServlet(urlPatterns = {"/json-builder"})
public class JsonBuilderServlet extends CommonHttpServlet {

    private static final String TITLE = "An sample usage of JsonBuilder (DOM-based APIs)";
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            StringBuilder content = new StringBuilder();
            
            // part 1 : build a simple object
            JsonObject jsonObject = example1();
            content.append("Example 1 : creating an simple object<br />");
            content.append("<pre><code>");
            content.append(jsonObject);
            content.append("</code></pre>");

            // part 2 : build a object with array*
            jsonObject = example2();
            content.append("Example 2 : creating an object with array<br />");
            content.append("<pre><code>");
            content.append(jsonObject.toString());
            content.append("</code></pre>");
            
            // part 3 : build a object with array
            jsonObject = example3();
            content.append("Example 3 : creating an object with array and embedded object<br />");
            content.append("<pre><code>");
            content.append(jsonObject.toString());
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
     *  Build a simple Json Object
     * 
     * @return 
     */
    public JsonObject example1()
    {
        return Json.createObjectBuilder()
                .add("firstName", "John")
                .add("lastName", "Smith")
                .add("age", 25)
             .build();        
    }
    
    /**
     *  Build a Json Object with Array
     * 
     * @return json object
     */
    public JsonObject example2()
    {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("firstName", "John")
                .add("lastName", "Smith")
                .add("age", 28)
                .add("phoneNumber", Json.createArrayBuilder()
                    .add(Json.createObjectBuilder()
                        .add("type", "home")
                        .add("number", "212 555-1234"))
                    .add(Json.createObjectBuilder()
                        .add("type", "fax")
                        .add("number", "646 555-4567")))
                .build(); 
        
        return jsonObject;
    }
    
    /**
     *  Build a Json Object with Array and Embedded Object
     * 
     * @return json object
     */
    public JsonObject example3()
    {
        // build the json embedded object
        JsonObject jsonEmbeddedObject = Json.createObjectBuilder()
                    .add("streetAddress", "21 2nd Street")
                    .add("city", "New York")
                    .add("state", "NY")
                    .add("postalCode", "10021")
                .build();
        
        // build the json array
        JsonArray jsonArray =  Json.createArrayBuilder()
                    .add(Json.createObjectBuilder()
                        .add("type", "home")
                        .add("number", "212 555-1234"))
                    .add(Json.createObjectBuilder()
                        .add("type", "fax")
                        .add("number", "646 555-4567"))
                    .build();
        
        JsonObject jsonObject =  Json.createObjectBuilder()
                .add("firstName", "John")
                .add("lastName", "Smith")
                .add("age", 25)
                .add("address", jsonEmbeddedObject)
                .add("phoneNumber", jsonArray)
                .build();  
        
        return jsonObject;
    }
}
