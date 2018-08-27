package com.example.gxtspringdemo.server.controller;

import com.example.gxtspringdemo.shared.DemoDTO;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.Produces;

@RestController
public class HelloController {

    @RequestMapping("/api/hello")
    @Produces("application/json")
    @ResponseBody
    public DemoDTO index() {
        return new DemoDTO("Greetings from Spring Boot!");
    }

}