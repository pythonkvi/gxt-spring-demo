package com.example.gxtspringdemo.client.book;

import com.example.gxtspringdemo.client.DefaultMethodCallback;
import com.example.gxtspringdemo.client.book.add.BookAddView;
import com.example.gxtspringdemo.client.event.BookAddEvent;
import com.example.gxtspringdemo.client.event.BookAddedEvent;
import com.example.gxtspringdemo.shared.model.Author;
import com.example.gxtspringdemo.shared.model.Book;
import com.example.gxtspringdemo.shared.service.AuthorService;
import com.example.gxtspringdemo.shared.service.BookService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.sencha.gxt.data.shared.ListStore;
import org.fusesource.restygwt.client.Method;

import java.util.Date;
import java.util.List;

public class BookPresenter {
    private final BookView view;
    private final BookAddView viewAdd;
    private final SimpleEventBus eventBus;

    private static final BookService BOOK_SERVICE = GWT.create(BookService.class);
    private static final AuthorService AUTHOR_SERVICE = GWT.create(AuthorService.class);

    public BookPresenter(BookView view, BookAddView viewAdd, SimpleEventBus eventBus) {
        this.view = view;
        this.eventBus = eventBus;
        this.viewAdd = viewAdd;

        view.setPresenter(this);
        viewAdd.setPresenter(this);
    }

    public void showView() {
        view.show();
    }

    public void handleAdd() {
        eventBus.fireEvent(new BookAddEvent());
    }

    public void handleRemove(List<Book> selectedItems) {
        for (Book book : selectedItems) {
            BOOK_SERVICE.delete(book, new DefaultMethodCallback<Void>() {
                @Override
                public void onSuccess(Method method, Void aVoid) {
                    // nothing
                }
            });
        }
    }

    public void list() {
        BOOK_SERVICE.list(new DefaultMethodCallback<List<Book>>() {
            @Override
            public void onSuccess(Method method, List<Book> books) {
                view.setBookList(books);
            }
        });
    }

    public void listAuthor() {
        AUTHOR_SERVICE.list(new DefaultMethodCallback<List<Author>>() {
            @Override
            public void onSuccess(Method method, List<Author> authors) {
                viewAdd.setAuthorList(authors);
            }
        });
    }

    public void handleSave() {
        final Book book = new Book();
        book.setISBN(viewAdd.getISBNValue());
        book.setTitle(viewAdd.getTitleValue());
        book.setAuthor(viewAdd.getAuthorValue());
        book.seteBook(viewAdd.getEBookValue());
        book.setDateAdd(new Date());

        BOOK_SERVICE.save(book, new DefaultMethodCallback<Void>() {

            @Override
            public void onSuccess(Method method, Void aVoid) {
                eventBus.fireEvent(new BookAddedEvent(book));
            }
        });
    }

    public void showViewAdd() {
        viewAdd.show();
    }

    public void hideViewAdd() {
        viewAdd.hide();
    }
}
