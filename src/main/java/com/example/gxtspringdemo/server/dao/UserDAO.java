package com.example.gxtspringdemo.server.dao;

import com.example.gxtspringdemo.shared.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User, String> {
    User findByLoginAndPassword(String login, String password);
}
