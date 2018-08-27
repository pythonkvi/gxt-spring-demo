package com.example.gxtspringdemo.server.dao;

import com.example.gxtspringdemo.shared.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDAO extends CrudRepository<Author, Integer> {
}
