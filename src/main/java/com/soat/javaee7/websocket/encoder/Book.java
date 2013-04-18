package com.soat.javaee7.websocket.encoder;

/**
 *  This class represents a book
 *
 * @author Julien Sadaoui
 */
public class Book {
    private String name;
    private String description;
    private String author;

    public Book(String name, String description, String author) {
        this.name = name;
        this.description = description;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
