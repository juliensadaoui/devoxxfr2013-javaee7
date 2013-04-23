package com.soat.javaee7.batch;

import static org.junit.Assert.assertEquals;

import com.soat.javaee7.batch.batchlet.BookBatchlet;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *  Simple test for {@link BookBatchlet}
 *
 * @author Julien Sadaoui
 */
public class BookBatchletTest
{
    /** Stream for catching System.out. */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final BookBatchlet batchlet = new BookBatchlet();

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

        assertEquals(batchlet.process(), "COMPLETED");
        assertEquals(outContent.toString(), "List of books (size=4): book1 book3 book4 book8");
    }
}
