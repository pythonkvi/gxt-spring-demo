package com.example.gxtspringdemo.shared.service;

import com.example.gxtspringdemo.shared.model.Book;
import org.fusesource.restygwt.client.Attribute;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

public interface BookService extends RestService {
    @GET
    @Path("../api/book")
    void list(MethodCallback<List<Book>> callback);

    @GET
    @Path("../api/book/{id}/delete")
    void delete(@PathParam("id") @Attribute("isbn") Book book, MethodCallback<Void> callback);

    @POST
    @Path("../api/book/save")
    void save(Book book, MethodCallback<Void> callback);
}
