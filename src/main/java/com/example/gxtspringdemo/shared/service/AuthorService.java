package com.example.gxtspringdemo.shared.service;

import com.example.gxtspringdemo.shared.model.Author;
import com.example.gxtspringdemo.shared.model.Book;
import org.fusesource.restygwt.client.RestService;
import org.fusesource.restygwt.client.MethodCallback;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

public interface AuthorService extends RestService {
    @GET
    @Path("../api/author")
    void list(MethodCallback<List<Author>> callback);
}
