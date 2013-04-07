/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.json;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *  An sample usage of JsonReader (DOM-based APIs)
 *  JsonBuilder - Reads a JSON object or array from the stream
 * 
 * @author Julien Sadaoui
 */
public class JsonReaderExample {
    
    /**
     *  Read the firstname from the JsonObject
     */
    public static String readFirstName(String json) 
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
    public static String readPhoneNumber(String json)
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
    public static String readPhoneType(String json)
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
    public static String readStreetAddress(String json)
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
