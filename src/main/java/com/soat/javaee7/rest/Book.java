package com.soat.javaee7.rest;

/**
 *  This class represents a book
 *
 * @author Julien Sadaoui
 */
public class Book {
    private String name;
    private String description;
    private String author;
    private Double price;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "name=" + name + ", description=" + description + ", author=" + author + ", price=" + price + '}';
    }
}
