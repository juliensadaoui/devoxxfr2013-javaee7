package com.soat.javaee7.concurrent.tasks;

import com.soat.javaee7.concurrent.Book;
import java.util.concurrent.Callable;

/**
 *  A task that connect to Amazon Web Services and retrieve the info for the book (simulate).
 *
 * @author Julien Sadaoui
 */
public class AmazonBookRetrieved implements Callable<Book>
{

    @Override
    public Book call() throws Exception
    {
        // Simulate that receiving the book takes between 0 and 4 seconds
        Thread.sleep(Math.round(Math.random()* 4.0 * 1000));
          
        return new Book("Spring par la pratique","Spring 2.5 et 3.0", 43, "Julien Dubois");
    }
}
