package com.soat.javaee7.batch.batchlet;

/**
 *
 * @author Julien Sadaoui
 */
public class Book 
{
    private String name;
    private int    stock;
    private int    year;

    public Book(String name, int stock, int year) {
        this.name  = name;
        this.stock = stock;
        this.year  = year;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public int getYear() {
        return year;
    }
}
