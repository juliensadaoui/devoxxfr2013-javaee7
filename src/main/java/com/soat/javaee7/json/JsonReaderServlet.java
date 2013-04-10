/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.json;

import com.soat.javaee7.servlet.CommonHttpServlet;
import java.io.IOException;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  An sample usage of JsonReader (DOM-based APIs)
 *  JsonBuilder - Reads a JSON object or array from the stream
 * 
 * @author Julien Sadaoui
 */
@WebServlet(urlPatterns = {"/json-reader"})
public class JsonReaderServlet extends CommonHttpServlet {
    
    private static final String TITLE = "An sample usage of JsonReader (DOM-based APIs)";
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException 
    {
        String json = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":25,\"address\":"
                + "{\"streetAddress\":\"21 2nd Street\",\"city\":\"New York\",\"state\":\"NY\",\"postalCode\":\"10021\"},"
                + "\"phoneNumber\":[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"fax\",\"number\":\"646 555-4567\"}]}";
        StringBuilder content = new StringBuilder();
        
        // part 1 : read the firstname from the json
        content.append("Example 1 : Read the firstname from the json<br />");
        content.append("<br />");
        content.append("Result: ").append(example1(json));
        content.append("<br />");
        
    }
    
    /**
     *  Read the firstname from the JsonObject
     */
    public String example1(String json) 
    {
        // create a JsonReader
        JsonReader reader = Json.createReader(new StringReader(json));
 
        // read a Json Object
        JsonObject jsonObject = reader.readObject();
        String firstName = jsonObject.getString("firstName");
        
        return firstName;
    }
    
    /**
     *  Read the phone number from the JsonObject
     */
    public String example2(String json)
    {
        // create a JsonReader
        JsonReader reader = Json.createReader(new StringReader(json));
 
        // read a Json Object
        JsonObject jsonObject = reader.readObject();
        JsonArray  jsonArray  = jsonObject.getJsonArray("phoneNumber");
        
        // Returns the json value at the first position in this array.
        JsonObject phoneNumber = jsonArray.getJsonObject(0);
        
        return phoneNumber.getString("number");
    }
    
    /**
     *  Read the phone number from the JsonObject
     */
    public String example3(String json)
    {
        // create a JsonReader
        JsonReader reader = Json.createReader(new StringReader(json));
 
        // read a JsonObject
        JsonObject jsonObject = reader.readObject();
        JsonArray  jsonArray  = jsonObject.getJsonArray("phoneNumber");
        
        // Returns the json value at the first position in this array.
        JsonObject phoneNumber = jsonArray.getJsonObject(0);
        
        return phoneNumber.getString("type");
    }
    
    /**
     *  Read the street address from the JsonObject
     */
    public String example4(String json)
    {
        // create a JsonReader
        JsonReader reader = Json.createReader(new StringReader(json));
 
        // read a JsonObject
        JsonObject jsonObject = reader.readObject();
        // Returns the object value with the name "address"
        JsonObject address = jsonObject.getJsonObject("address");
        
        return address.getString("streetAddress");
    }
}
