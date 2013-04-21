package com.soat.javaee7.batch.batchlet;

import java.util.ArrayList;
import java.util.List;
import javax.batch.api.Batchlet;

/**
 *  This batchlet removes the items if quantity equal to 0
 *
 * @author Julien Sadaoui
 */
public class BookBatchlet implements Batchlet
{
    private List<Book> books = new ArrayList<Book>() {{
        add(new Book("book1",55));
        add(new Book("book2",0));
        add(new Book("book3",15));
        add(new Book("book4",30));
        add(new Book("book5",0));
        add(new Book("book6",0));
        add(new Book("book7",0));
        add(new Book("book8",3));
    }};
    

    @Override
    public String process() throws Exception {
        
        for (Book book : books) {
            
            if (book.getQuantity() == 0) {
                books.remove(book);
            }
        }
        
        return "SUCCESS";
    }

    @Override
    public void stop() throws Exception {
        
    }
    
}
