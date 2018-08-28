package com.example.gxtspringdemo.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class BookAddEvent extends GwtEvent<BookAddEvent.BookAddHandler> {
    private static Type<BookAddHandler> TYPE;

    @Override
    public Type<BookAddHandler> getAssociatedType() {
        return TYPE();
    }

    public static Type<BookAddHandler> TYPE() {
        if (TYPE == null) {
            TYPE = new Type<>();
        }
        return TYPE;
    }

    @Override
    protected void dispatch(BookAddHandler handler) {
        handler.onBookAdd();
    }

    public interface BookAddHandler extends EventHandler {
        void onBookAdd();
    }
}
