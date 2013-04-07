/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.json;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

/**
 *  An sample usage of JsonBuilder (DOM-based APIs)
 *  JsonBuilder - Builds a JSON object or JSON array 
 * 
 * @author Julien Sadaoui
 */
public class JsonBuilderExample 
{
    /**
     *  Build a simple Json Object
     * 
     * @return 
     */
    public static JsonObject buildJsonObject()
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
    public static JsonObject buildJsonObjectWithArray()
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
    public static JsonObject buildJsonObjectWithArrayAndEmbeddedObject()
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
