package com.soat.javaee7.batch;

import com.soat.javaee7.batch.chunk.Book;
import com.soat.javaee7.batch.chunk.BookItemWriter;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *  Simple test for {@link BookItemWriter}
 *
 * @author Julien Sadaoui
 */
public class BookItemWriterTest 
{
    /** Stream for catching System.out. */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final BookItemWriter itemWriter = new BookItemWriter();

    private final List books = new ArrayList() {{
        add(createBookBean("book1","description1","author1",2000,10));
        add(createBookBean("book2","description2","author2",2000,15));
    }};
    
    /**
     *  catch system out
     */
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     *  Reset JVM standard
     */
    @After
    public void tearDown() {
        System.setOut(null);
    } 
    
    @Test
    public void shouldCheckListOfBooks() throws Exception {
        itemWriter.open(null);
        itemWriter.writeItems(books);
        itemWriter.close();
        
        assertEquals(outContent.toString(), "[{\"name\":\"book1\",\"description\":\"description1\",\"author\":\"author1\",\"year\":2000,\"price\":10.0},{\"name\":\"book2\",\"description\":\"description2\",\"author\":\"author2\",\"year\":2000,\"price\":15.0}]");
    }
    
    /**
     *  Creates a {@link Book} instance
     */
    private static Book createBookBean(String name, String description, 
            String author, int year, double price)
    {
        Book book = new Book();
        book.setName(name);
        book.setDescription(description);
        book.setAuthor(author);
        book.setYear(year);
        book.setPrice(price);
        return book;
    }
}
