package com.example.gxtspringdemo.client.event;

import com.example.gxtspringdemo.shared.model.Book;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class BookDeletedEvent extends GwtEvent<BookDeletedEvent.BookDeletedHandler> {
    private static Type<BookDeletedHandler> TYPE;
    private final Book book;

    public BookDeletedEvent(Book book) {
        this.book = book;
    }

    @Override
    public Type<BookDeletedHandler> getAssociatedType() {
        return TYPE();
    }

    public static Type<BookDeletedHandler> TYPE() {
        if (TYPE == null) {
            TYPE = new Type<>();
        }
        return TYPE;
    }

    @Override
    protected void dispatch(BookDeletedHandler handler) {
        handler.onBookDeleted(book);
    }

    public interface BookDeletedHandler extends EventHandler {
        void onBookDeleted(Book book);
    }
}
