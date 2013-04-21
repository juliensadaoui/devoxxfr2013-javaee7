package com.soat.javaee7.batch.chunk;

import javax.batch.api.chunk.ItemProcessor;

/**
 * This class processes a book item. 
 * The price of book is updated if the year is divisible by 2.
 *
 * @author Julien Sadaoui
 */
public class BookItemProcessor implements ItemProcessor<Book, Book>
{
    @Override
    public Book processItem(Book book) throws Exception {
        int year = book.getYear();
        if ((year % 2) == 0) {          
            double price = book.getPrice();      
            price -= (price * 15) / 100;
            book.setPrice(price);
        }
        
        return book;
    }
}
