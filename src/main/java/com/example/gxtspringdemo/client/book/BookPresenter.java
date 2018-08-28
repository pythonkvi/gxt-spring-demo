package com.example.gxtspringdemo.client.book;

import com.example.gxtspringdemo.client.AlertUtils;
import com.example.gxtspringdemo.client.DefaultMethodCallback;
import com.example.gxtspringdemo.client.book.add.BookAddView;
import com.example.gxtspringdemo.client.event.BookAddEvent;
import com.example.gxtspringdemo.client.event.BookAddedEvent;
import com.example.gxtspringdemo.client.event.BookDeletedEvent;
import com.example.gxtspringdemo.shared.model.Author;
import com.example.gxtspringdemo.shared.model.Book;
import com.example.gxtspringdemo.shared.service.AuthorService;
import com.example.gxtspringdemo.shared.service.BookService;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.sencha.gxt.data.shared.ListStore;
import org.fusesource.restygwt.client.Method;

import javax.annotation.Nullable;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BookPresenter {
    private final BookView view;
    private final BookAddView viewAdd;

    @Inject
    private SimpleEventBus eventBus;

    @Inject
    private BookService BOOK_SERVICE;

    @Inject
    private AuthorService AUTHOR_SERVICE;

    final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Inject
    public BookPresenter(BookView view, BookAddView viewAdd) {
        this.view = view;
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
        for (final Book book : selectedItems) {
            BOOK_SERVICE.delete(book, new DefaultMethodCallback<Void>() {
                @Override
                public void onSuccess(Method method, Void aVoid) {
                    eventBus.fireEvent(new BookDeletedEvent(book));
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
        book.setIsbn(viewAdd.getISBNValue());
        book.setTitle(viewAdd.getTitleValue());
        book.setAuthor(viewAdd.getAuthorValue());
        book.seteBook(viewAdd.getEBookValue());
        book.setDateAdd(new Date());

        Set<ConstraintViolation<Book>> validateErrors = validator.validate(book);
        if (!validateErrors.isEmpty()) {
            AlertUtils.showError(Joiner.on("<br/>").join(Iterables.transform(validateErrors, new Function<ConstraintViolation<Book>, Object>() {
                @Nullable
                @Override
                public Object apply(@Nullable ConstraintViolation<Book> input) {
                    return input.getMessage();
                }
            })));
            return;
        }

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
