package com.example.gxtspringdemo.server.controller;

import com.example.gxtspringdemo.server.dao.AuthorDAO;
import com.example.gxtspringdemo.shared.model.Author;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    AuthorDAO authorDAO;

    @RequestMapping("/api/author")
    @Produces("application/json")
    @ResponseBody
    public List<Author> list() {
        return ImmutableList.copyOf(authorDAO.findAll());
    }
}
