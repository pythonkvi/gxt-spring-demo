package com.example.gxtspringdemo.server.controller;

import com.example.gxtspringdemo.server.dao.UserDAO;
import com.example.gxtspringdemo.shared.DemoDTO;
import com.example.gxtspringdemo.shared.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

@RestController
public class UserController {
    @Autowired
    UserDAO userDAO;

    @RequestMapping("/api/user")
    @Produces("application/json")
    @Consumes("application/json")
    public DemoDTO checkLoginPassword(@RequestBody User user) {
        return userDAO.findByLoginAndPassword(user.getLogin(), user.getPassword()) == null ? new DemoDTO("Invalid credentials") : null;
    }
}
