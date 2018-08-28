package com.example.gxtspringdemo.client;

import com.example.gxtspringdemo.client.book.BookPresenter;
import com.example.gxtspringdemo.client.book.BookView;
import com.example.gxtspringdemo.client.book.add.BookAddView;
import com.example.gxtspringdemo.client.event.BookAddEvent;
import com.example.gxtspringdemo.client.event.BookAddedEvent;
import com.example.gxtspringdemo.client.event.BookDeletedEvent;
import com.example.gxtspringdemo.client.event.LoginSuccessEvent;
import com.example.gxtspringdemo.client.login.LoginPresenter;
import com.example.gxtspringdemo.client.login.LoginView;
import com.example.gxtspringdemo.shared.DemoDTO;
import com.example.gxtspringdemo.shared.model.Book;
import com.example.gxtspringdemo.shared.service.DemoService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.container.Viewport;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;

public class DemoEntryPoint implements EntryPoint {
    private final DemoGinInjector injector = GWT.create(DemoGinInjector.class);

    @Override
    public void onModuleLoad() {
        DemoService service = GWT.create(DemoService.class);
        service.hello(new DefaultMethodCallback<DemoDTO>() {
            @Override
            public void onSuccess(Method method, DemoDTO s) {
                GWT.log(s.getMsg());
            }
        });

        final BookView bookView = injector.bookView();

        init();

        Viewport viewport = new Viewport();
        viewport.add(bookView);

        RootPanel.get().add(viewport);

        Defaults.setDateFormat("yyyy-MM-dd");
    }

    private void init() {
        SimpleEventBus eventBus = injector.eventBus();

        final LoginPresenter loginPresenter = injector.loginPresenter();
        loginPresenter.showView();

        final BookPresenter bookPresenter = injector.bookPresenter();

        eventBus.addHandler(LoginSuccessEvent.TYPE(), new LoginSuccessEvent.LoginSuccessHandler() {
            @Override
            public void onLoginSuccess() {
                bookPresenter.list();
                bookPresenter.showView();
            }
        });

        eventBus.addHandler(BookAddEvent.TYPE(), new BookAddEvent.BookAddHandler() {
            @Override
            public void onBookAdd() {
                bookPresenter.showViewAdd();
            }
        });

        eventBus.addHandler(BookAddedEvent.TYPE(), new BookAddedEvent.BookAddedHandler() {
            @Override
            public void onBookAdded(Book book) {
                bookPresenter.hideViewAdd();
                bookPresenter.list();
            }
        });

        eventBus.addHandler(BookDeletedEvent.TYPE(), new BookDeletedEvent.BookDeletedHandler() {
            @Override
            public void onBookDeleted(Book book) {
                bookPresenter.list();
            }
        });
    }
}
