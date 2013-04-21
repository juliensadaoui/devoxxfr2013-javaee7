package com.soat.javaee7.batch.batchlet;

/**
 *
 * @author Julien Sadaoui
 */
public class Book 
{
    private String name;
    private int    quantity;

    public Book(String name, int quantity) {
        this.name  = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
