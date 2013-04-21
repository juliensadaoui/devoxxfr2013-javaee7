package com.soat.javaee7.batch.chunk;

import java.util.List;
import javax.batch.api.chunk.AbstractItemWriter;

/**
 *  This class writes the items in a cache
 *
 * @author Julien
 */
public class BookItemWriter extends AbstractItemWriter<Book>
{
    
    @Override
    public void writeItems(List<Book> books) throws Exception {
        
    }
}
