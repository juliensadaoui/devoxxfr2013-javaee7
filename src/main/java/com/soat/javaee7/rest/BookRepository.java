/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  This class represents a collection of books
 *
 * @author Julien Sadaoui
 */
public class BookRepository 
{
    private static final Map<String,Book> books = new HashMap<>();
    
    /**
     *  Gets a book with the given name
     * 
     * @param name of book 
     * @return book to search
     */
    public static Book get(String name) {
        return books.get(name);
    }
    
    /**
     *  Gets all books
     * 
     * @return 
     */
    public static List<Book> getAll() {       
        return new ArrayList<>(books.values());
    }
    
    /**
     * Add the given book or replace the old book
     * 
     * @param book to added or updated
     */
    public static void add(Book book) {
        books.put(book.getName(), book);
    }
    
    /**
     *  Removes the given book
     * 
     * @param book to deleted
     */
    public static void delete(Book book) {
        books.remove(book.getName());
    }
}
