package com.example.gxtspringdemo.client.login;

import com.example.gxtspringdemo.client.AlertUtils;
import com.example.gxtspringdemo.client.DefaultMethodCallback;
import com.example.gxtspringdemo.client.event.LoginSuccessEvent;
import com.example.gxtspringdemo.shared.DemoDTO;
import com.example.gxtspringdemo.shared.model.User;
import com.example.gxtspringdemo.shared.service.UserService;
import com.google.common.base.Strings;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import org.fusesource.restygwt.client.Method;

public class LoginPresenter {
    private final LoginView view;
    private final SimpleEventBus eventBus;

    private static final UserService USER_SERVICE = GWT.create(UserService.class);

    public LoginPresenter(LoginView view, SimpleEventBus eventBus) {
        this.view = view;
        this.eventBus = eventBus;

        view.setPresenter(this);
    }


    public void showView() {
        view.show();
    }

    public void handleOk() {
        User user = new User();
        user.setLogin(view.getLoginValue());
        user.setPassword(view.getPasswordValue());

        USER_SERVICE.check(user, new DefaultMethodCallback<DemoDTO>() {
            @Override
            public void onSuccess(Method method, DemoDTO demoDTO) {
                if (Strings.isNullOrEmpty(demoDTO.getMsg())) {
                    eventBus.fireEvent(new LoginSuccessEvent());
                } else {
                    AlertUtils.showError(demoDTO.getMsg());
                }
            }
        });
    }
}
