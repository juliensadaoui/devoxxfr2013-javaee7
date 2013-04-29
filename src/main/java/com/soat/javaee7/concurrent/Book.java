package com.soat.javaee7.concurrent;

/**
 *  This class represents a book instance
 *
 * @author Julien Sadaoui
 */
public class Book 
{
    private String title;
    private String description;
    private double price;
    private String author;

    public Book(String title, String description, double price, String author) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", description=" + description + ", price=" + price + ", author=" + author + '}';
    }
}
