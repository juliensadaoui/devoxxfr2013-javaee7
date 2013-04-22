package com.soat.javaee7.websocket.encoder;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 *  A example endpoint that encodes/decodes a custom objet (book)
 *
 * @author Julien Sadaoui
 */
@ServerEndpoint(value = "/websocket-encoder-book",
        encoders = { BookEncoder.class },
        decoders = { BookDecoder.class })
public class BookBean 
{   
    @OnMessage
    public Book updateBook(Book book) {
        book.setName("Updated" + book.getName());
        book.setDescription("Updated" + book.getDescription());
        book.setAuthor("Updated" + book.getAuthor());
        return book;
    }
}
