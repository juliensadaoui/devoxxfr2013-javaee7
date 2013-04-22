package com.soat.javaee7.websocket.encoder;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *  Converts a book object into a json message.
 *
 * @author Julien Sadaoui
 */
public class BookEncoder implements Encoder.Text<Book> {

    @Override
    public String encode(Book book) throws EncodeException {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("name", book.getName())
                .add("description", book.getDescription())
                .add("author", book.getAuthor())
             .build();
        
        return jsonObject.toString();
    }

    @Override
    public void init(EndpointConfig ec) {
    }

    @Override
    public void destroy() {
    }
}

