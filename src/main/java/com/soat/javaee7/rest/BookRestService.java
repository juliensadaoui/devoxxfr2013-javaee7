package com.soat.javaee7.rest;

import java.net.URI;
import java.util.List;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Julien
 */
@Path("/rest-book")
public class BookRestService 
{
    @Context
    private UriInfo uriInfo;
    
    @GET
    @Path("service-name")
    @Produces("text/plain")
    public Response getServiceName() {
        return Response.ok("BookRestService").build();
    }
    
    @GET
    @Path("{name}")
    public Response getBook(@PathParam("name") String name)
    {
        Book book = BookRepository.get(name);
        if (book == null) 
            throw new NotFoundException();
        
        return Response.ok(book).build();
    }
    
    @GET
    public Response getAllBooks() 
    {
        List<Book> books = BookRepository.getAll();
        return Response.ok(books).build();
    }
    
    @POST
    public Response createBook(Book book) {
        BookRepository.add(book);
        URI uri = uriInfo.getAbsolutePathBuilder().path(book.getName()).build();
        return Response.ok(uri).build();
    }
    
    @PUT
    public Response updateBook(Book book) {
        BookRepository.add(book);
        return Response.ok().build();
    }
    
    @DELETE
    public Response deleteBook(Book book) {
        BookRepository.delete(book);
        return Response.noContent().build();
    }
}
