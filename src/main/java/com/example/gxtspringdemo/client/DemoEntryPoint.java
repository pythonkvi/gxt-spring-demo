package com.example.gxtspringdemo.client;

import com.example.gxtspringdemo.client.book.BookPresenter;
import com.example.gxtspringdemo.client.book.BookView;
import com.example.gxtspringdemo.client.book.add.BookAddView;
import com.example.gxtspringdemo.client.event.BookAddEvent;
import com.example.gxtspringdemo.client.event.BookAddedEvent;
import com.example.gxtspringdemo.client.event.LoginSuccessEvent;
import com.example.gxtspringdemo.client.login.LoginView;
import com.example.gxtspringdemo.client.login.LoginPresenter;
import com.example.gxtspringdemo.shared.DemoDTO;
import com.example.gxtspringdemo.shared.model.Book;
import com.example.gxtspringdemo.shared.service.DemoService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import org.fusesource.restygwt.client.Method;

public class DemoEntryPoint implements EntryPoint {
    private SimpleEventBus eventBus;

    @Override
    public void onModuleLoad() {
        HorizontalLayoutContainer panel = new HorizontalLayoutContainer();
        eventBus = new SimpleEventBus();

        final FieldLabel fieldLabel = new FieldLabel();
        panel.add(fieldLabel);

        DemoService service = GWT.create(DemoService.class);
        service.hello(new DefaultMethodCallback<DemoDTO>() {
            @Override
            public void onSuccess(Method method, DemoDTO s) {
                fieldLabel.setText(s.getMsg());
            }
        });

        init();

        Viewport viewport = new Viewport();
        viewport.add(panel);

        RootPanel.get().add(viewport);
    }

    private void init() {
        final LoginPresenter loginPresenter = new LoginPresenter(new LoginView(), eventBus);
        loginPresenter.showView();

        final BookPresenter bookPresenter = new BookPresenter(new BookView(), new BookAddView(), eventBus);

        eventBus.addHandler(LoginSuccessEvent.TYPE(), new LoginSuccessEvent.LoginSuccessHandler() {
            @Override
            public void onLoginSuccess() {
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
    }
}
