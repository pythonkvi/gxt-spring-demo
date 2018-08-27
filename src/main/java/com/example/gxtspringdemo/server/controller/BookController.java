package com.example.gxtspringdemo.server.controller;

import com.example.gxtspringdemo.server.dao.BookDAO;
import com.example.gxtspringdemo.shared.model.Book;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookDAO bookDAO;

    @RequestMapping("/api/book")
    @Produces("application/json")
    @ResponseBody
    public List<Book> list() {
        return ImmutableList.copyOf(bookDAO.findAll());
    }

    @RequestMapping("/api/book/{id}/delete")
    @Produces("application/json")
    public void delete(@PathVariable("id") String id) {
        bookDAO.delete(bookDAO.findById(id).get());
    }

    @RequestMapping("/api/book/save")
    @Produces("application/json")
    public void save(Book book) {
        bookDAO.save(book);
    }

}
