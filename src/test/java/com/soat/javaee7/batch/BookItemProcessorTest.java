package com.soat.javaee7.batch;

import com.soat.javaee7.batch.chunk.Book;
import com.soat.javaee7.batch.chunk.BookItemProcessor;
import static org.fest.assertions.Assertions.assertThat;
import org.junit.Test;

/**
 *  Simple test for {@link BookItemProcessor}
 *
 * @author Julien Sadaoui
 */
public class BookItemProcessorTest {
    
    /**
     * Test 1: The year is divisible by 2, the price is updated
     * 
     * @throws Exception 
     */
    @Test
    public void shouldUpdateThePriceOfBook() throws Exception {
        Book book = new Book();
        book.setName("book1");
        book.setDescription("description1");
        book.setAuthor("author1");
        book.setYear(2002);
        book.setPrice(10);
             
        BookItemProcessor processor = new BookItemProcessor();
        book = (Book) processor.processItem(book);
        
        assertThat(book.getPrice()).isEqualTo(8.5);
    }
    
    /**
     * Test 2: The year is not divisible by 2, the price is not updated
     * 
     * @throws Exception 
     */
    @Test
    public void shouldNotUpdateThePriceOfBook() throws Exception {
        Book book = new Book();
        book.setName("book2");
        book.setDescription("description2");
        book.setAuthor("author2");
        book.setYear(199);
        book.setPrice(25);
             
        BookItemProcessor processor = new BookItemProcessor();
        book = (Book) processor.processItem(book);
        
        assertThat(book.getPrice()).isEqualTo(25);
    }
}
