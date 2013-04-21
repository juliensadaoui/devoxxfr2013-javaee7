package com.soat.javaee7.batch.chunk;

import java.io.Serializable;
import java.util.List;
import javax.batch.api.chunk.ItemWriter;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

/**
 *  This class writes the JSON data (book item) to the  "standard" output.
 *
 * @author Julien
 */
public class BookItemWriter implements ItemWriter<Book>
{
    private JsonArrayBuilder builder;
    
    @Override
    public void writeItems(List<Book> books) throws Exception {
        
        for (Book book : books) {
            builder.add(Json.createObjectBuilder()
                .add("name", book.getName())
                .add("description", book.getDescription())
                .add("author", book.getAuthor())
                .add("year", book.getYear())
                .add("price", book.getPrice())
            );
        }
    }

    @Override
    public void open(Serializable srlzbl) throws Exception {
        builder = Json.createArrayBuilder();
    }

    @Override
    public void close() throws Exception {
        JsonArray result = builder.build();
        System.out.println(result.toString());
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return null;
    }
}
