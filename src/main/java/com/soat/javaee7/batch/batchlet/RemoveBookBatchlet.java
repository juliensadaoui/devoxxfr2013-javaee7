package com.soat.javaee7.batch.batchlet;

import java.util.ArrayList;
import java.util.List;
import javax.batch.api.Batchlet;

/**
 *
 * @author Julien Sadaoui
 */
public class RemoveBookBatchlet implements Batchlet
{
    private List<Book> books = new ArrayList<Book>() {{
        add(new Book("book1",55,1990));
        add(new Book("book2",0,1960));
        add(new Book("book3",15,2012));
        add(new Book("book4",30,1977));
        add(new Book("book5",0,1986));
        add(new Book("book6",0,2010));
        add(new Book("book7",0,1998));
        add(new Book("book8",3,2001));
    }};
    

    @Override
    public String process() throws Exception {
        
        for (Book book : books) {
            
            if ((book.getStock() == 0)
                && (book.getYear() < 2000)) {
                
                books.remove(book);
            }
        }
        
        return "SUCCESS";
    }

    @Override
    public void stop() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
