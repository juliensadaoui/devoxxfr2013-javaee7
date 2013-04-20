/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.batch.chunk;

import javax.batch.api.chunk.ItemProcessor;

/**
 *
 * @author Julien
 */
public class BookItemProcessor implements ItemProcessor<Book, Book>
{
    @Override
    public Book processItem(Book t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
