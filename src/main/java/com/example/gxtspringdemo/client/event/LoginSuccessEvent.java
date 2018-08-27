package com.example.gxtspringdemo.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class LoginSuccessEvent extends GwtEvent<LoginSuccessEvent.LoginSuccessHandler> {
    private static Type<LoginSuccessHandler> TYPE;

    @Override
    public Type<LoginSuccessHandler> getAssociatedType() {
        if (TYPE == null) {
            TYPE = new Type<>();
        }
        return TYPE;
    }

    public static Type<LoginSuccessHandler> TYPE() {
        return TYPE;
    }

    @Override
    protected void dispatch(LoginSuccessHandler handler) {
        handler.onLoginSuccess();
    }

    public interface LoginSuccessHandler extends EventHandler {
        void onLoginSuccess();
    }
}
