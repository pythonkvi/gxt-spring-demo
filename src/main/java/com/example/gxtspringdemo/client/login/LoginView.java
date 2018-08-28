package com.example.gxtspringdemo.client.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;

public class LoginView implements IsWidget {
    final Window window = new Window();

    interface LoginUiBinder extends UiBinder<VerticalLayoutContainer, LoginView> {
    }

    private static LoginUiBinder ourUiBinder = GWT.create(LoginUiBinder.class);

    private VerticalLayoutContainer container;

    private LoginPresenter presenter;

    @UiField
    TextField login;
    @UiField
    PasswordField password;
    @UiField
    TextButton ok;
    @UiField
    TextButton clear;

    public LoginView() {
        container = ourUiBinder.createAndBindUi(this);
        window.setWidget(container);
    }

    @Override
    public Widget asWidget() {
        return container;
    }

    @UiHandler("ok")
    public void okSelect(SelectEvent event) {
        presenter.handleOk();
    }

    @UiHandler("clear")
    public void clearSelect(SelectEvent event) {
        login.setValue("");
        password.setValue("");
    }

    public void show() {
        window.show();
    }

    public String getLoginValue() {
        return login.getCurrentValue();
    }

    public String getPasswordValue() {
        return password.getCurrentValue();
    }

    public void hide() {
        window.hide();
    }

    public void setPresenter(LoginPresenter presenter) {
        this.presenter = presenter;
    }
}
