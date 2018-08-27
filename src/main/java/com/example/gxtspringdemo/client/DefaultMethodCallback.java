package com.example.gxtspringdemo.client;

import com.google.gwt.user.client.Window;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

public abstract class DefaultMethodCallback<T> implements MethodCallback<T> {
    @Override
    public void onFailure(Method method, Throwable throwable) {
        Window.alert(throwable.getLocalizedMessage());
    }
}
