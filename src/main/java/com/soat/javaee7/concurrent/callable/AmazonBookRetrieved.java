package com.soat.javaee7.concurrent.callable;

import com.soat.javaee7.concurrent.Book;
import java.util.concurrent.Callable;

/**
 *  A task that connect to Amazon Web Services and retrieve the info for the book. 
 *  Callable interface is a task that returns a result and may throw an exception
 * 
 * @author Julien Sadaoui
 */
public class AmazonBookRetrieved implements Callable<Book>
{
    @Override
    public Book call() throws Exception {
        
        try {
            // Simulate that receiving the book takes between 0 and 2 seconds
            Thread.sleep(Math.round(Math.random()* 2.0 * 1000));
          
        } catch (InterruptedException e) {}
        
        return new Book("Java EE 6 with GlassFish 3","Java Enterprise Edition (Java EE)",45,"Antonio Goncalves");
    }
}
