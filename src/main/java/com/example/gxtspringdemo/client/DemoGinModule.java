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
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class DemoGinModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(SimpleEventBus.class).in(Singleton.class);
        bind(LoginView.class).in(Singleton.class);
        bind(LoginPresenter.class).in(Singleton.class);
        bind(BookPresenter.class).in(Singleton.class);
        bind(BookAddView.class).in(Singleton.class);
        bind(BookView.class).in(Singleton.class);
        bind(BookService.class).in(Singleton.class);
        bind(AuthorService.class).in(Singleton.class);
        bind(UserService.class).in(Singleton.class);
    }
}
