package com.example.gxtspringdemo.client.event;

import com.example.gxtspringdemo.shared.model.Book;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class BookAddedEvent extends GwtEvent<BookAddedEvent.BookAddedHandler> {
    private static Type<BookAddedHandler> TYPE;
    private final Book book;

    public BookAddedEvent(Book book) {
        this.book = book;
    }

    @Override
    public Type<BookAddedHandler> getAssociatedType() {
        return TYPE();
    }

    public static Type<BookAddedHandler> TYPE() {
        if (TYPE == null) {
            TYPE = new Type<>();
        }
        return TYPE;
    }

    @Override
    protected void dispatch(BookAddedHandler handler) {
        handler.onBookAdded(book);
    }

    public interface BookAddedHandler extends EventHandler {
        void onBookAdded(Book book);
    }
}
