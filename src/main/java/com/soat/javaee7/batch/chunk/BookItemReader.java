package com.soat.javaee7.batch.chunk;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import javax.batch.api.chunk.ItemReader;


/**
 * This class reads a book item from the filesystem.
 * The file is located in the classpath
 *
 * @author Julien Sadaoui
 */
public class BookItemReader implements ItemReader<Book>
{
    private BufferedReader br;
    
    @Override
    public Book readItem() throws Exception {
        String line = br.readLine();
        if (line != null) {
            String [] fields = line.split(",");
            
            Book book = new Book();
            book.setName(fields[0]);
            book.setDescription(fields[1]);
            book.setAuthor(fields[2]);
            book.setYear(Integer.parseInt(fields[3]));
            book.setPrice(Double.parseDouble(fields[4]));
            return book;
        }
        return null;
    }

    @Override
    public void open(Serializable srlzbl) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream ips = classLoader.getResourceAsStream("batch/books.txt");
	InputStreamReader ipsr=new InputStreamReader(ips);
	br = new BufferedReader(ipsr);
    }

    @Override
    public void close() throws Exception {
        br.close();
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return null;
    }

    
}
