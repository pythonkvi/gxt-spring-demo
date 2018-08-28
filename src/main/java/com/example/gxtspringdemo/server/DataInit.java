package com.example.gxtspringdemo.server;

import com.example.gxtspringdemo.server.dao.AuthorDAO;
import com.example.gxtspringdemo.server.dao.BookDAO;
import com.example.gxtspringdemo.server.dao.UserDAO;
import com.example.gxtspringdemo.shared.model.Author;
import com.example.gxtspringdemo.shared.model.Book;
import com.example.gxtspringdemo.shared.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {
    @Autowired
    UserDAO userDAO;

    @Autowired
    BookDAO bookDAO;

    @Autowired
    AuthorDAO authorDAO;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        user.setLogin("admin");
        user.setPassword("admin");
        userDAO.save(user);

        Author author = new Author();
        author.setLastName("Tolstoj");
        author.setMiddleName("Nikolaevich");
        author.setFirstName("Lion");
        author.setBirthYear(1828);
        authorDAO.save(author);

        Book book = new Book();
        book.setIsbn("1234-5678-90");
        book.setAuthor(author);
        book.setTitle("War and peace");
        bookDAO.save(book);
    }
}
