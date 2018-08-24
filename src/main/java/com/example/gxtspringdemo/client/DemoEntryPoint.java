package com.example.gxtspringdemo.client;

import com.example.gxtspringdemo.shared.DemoDTO;
import com.example.gxtspringdemo.shared.DemoService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

public class DemoEntryPoint implements EntryPoint {
    @Override
    public void onModuleLoad() {
        HorizontalLayoutContainer panel = new HorizontalLayoutContainer();

        final FieldLabel fieldLabel = new FieldLabel();
        panel.add(fieldLabel);

        DemoService service = GWT.create(DemoService.class);
        service.hello(new MethodCallback<DemoDTO>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                Window.alert(throwable.getLocalizedMessage());
            }

            @Override
            public void onSuccess(Method method, DemoDTO s) {
                fieldLabel.setText(s.getMsg());
            }
        });

        Viewport viewport = new Viewport();
        viewport.add(panel);

        RootPanel.get().add(viewport);
    }
}
