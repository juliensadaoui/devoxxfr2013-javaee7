/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.batch.chunk;

import java.util.List;
import javax.batch.api.chunk.AbstractItemWriter;

/**
 *
 * @author Julien
 */
public class BookItemWriter extends AbstractItemWriter<Book>
{
    @Override
    public void writeItems(List<Book> list) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
