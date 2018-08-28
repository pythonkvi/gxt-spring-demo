package com.example.gxtspringdemo.client;

import com.example.gxtspringdemo.client.book.BookPresenter;
import com.example.gxtspringdemo.client.book.BookView;
import com.example.gxtspringdemo.client.book.add.BookAddView;
import com.example.gxtspringdemo.client.login.LoginPresenter;
import com.example.gxtspringdemo.client.login.LoginView;
import com.example.gxtspringdemo.shared.service.AuthorService;
import com.example.gxtspringdemo.shared.service.BookService;
import com.example.gxtspringdemo.shared.service.UserService;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(DemoGinModule.class)
public interface DemoGinInjector extends Ginjector {
    SimpleEventBus eventBus();

    LoginView loginView();

    LoginPresenter loginPresenter();

    BookPresenter bookPresenter();

    BookView bookView();

    BookAddView bookAddView();

    BookService bookService();

    AuthorService authorService();

    UserService userService();
}
