package com.example.gxtspringdemo.server.controller;

import com.example.gxtspringdemo.server.dao.BookDAO;
import com.example.gxtspringdemo.shared.model.Book;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/api/book/{isbn}/delete")
    @Produces("application/json")
    public Map delete(@PathVariable("isbn") String isbn) {
        bookDAO.deleteById(isbn);
        return Collections.emptyMap();
    }

    @RequestMapping("/api/book/save")
    @Consumes("application/json")
    @Produces("application/json")
    public Map save(@RequestBody Book book) {
        bookDAO.save(book);
        return Collections.emptyMap();
    }

}
