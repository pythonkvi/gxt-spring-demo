package com.example.gxtspringdemo.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validator;

@Configuration
public class MvcValidatorConfiguration {
    @Bean
    public Validator jsr303Validator() {
        return new MockValidator();
    }
}
