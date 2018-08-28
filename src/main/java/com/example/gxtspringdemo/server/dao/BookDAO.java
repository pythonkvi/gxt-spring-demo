package com.example.gxtspringdemo.server.dao;

import com.example.gxtspringdemo.shared.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO extends CrudRepository<Book, String> {
    @Override
    Iterable<Book> findAll();
}
