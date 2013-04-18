/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.websocket.encoder;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;


/**
 *  
 *
 * @author Julien Sadaoui
 */
public class BookDecoder implements Decoder.Text<Book>
{

    @Override
    public Book decode(String message) throws DecodeException {

        JsonReader reader = Json.createReader(new StringReader(message));
        JsonObject jsonObject = reader.readObject();
        
        String name        = jsonObject.getString("name");
        String description = jsonObject.getString("description");
        String author      = jsonObject.getString("author");
        
       return new Book(name, description, author);
    }

    @Override
    public boolean willDecode(String message) {
        return true;
    }

    @Override
    public void init(EndpointConfig ec) {
    }

    @Override
    public void destroy() {
    }
    
}
