package com.example.gxtspringdemo.client.book.add;

import com.example.gxtspringdemo.client.author.AuthorProp;
import com.example.gxtspringdemo.client.book.BookPresenter;
import com.example.gxtspringdemo.shared.model.Author;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.TextField;

import java.util.List;

public class BookAddView implements IsWidget {

    interface BookAddUiBinder extends UiBinder<VerticalLayoutContainer, BookAddView> {
    }

    final Window window = new Window();
    private static BookAddUiBinder ourUiBinder = GWT.create(BookAddUiBinder.class);
    private static final AuthorProp AUTHOR_PROP = GWT.create(AuthorProp.class);

    private VerticalLayoutContainer container;
    private BookPresenter presenter;

    @UiField(provided = true)
    ComboBox<Author> author;
    @UiField
    TextButton save;
    @UiField
    TextButton close;
    @UiField
    TextField ISBN;
    @UiField
    TextField title;
    @UiField
    CheckBox eBook;

    public BookAddView() {
        author = new ComboBox<>(new ListStore<Author>(AUTHOR_PROP.key()), AUTHOR_PROP.label());

        container = ourUiBinder.createAndBindUi(this);

        window.setWidget(container);
    }

    @Override
    public Widget asWidget() {
        return container;
    }

    public void show() {
        presenter.listAuthor();
        window.show();
    }

    public void hide() {
        window.hide();
    }

    public void setAuthorList(List<Author> authors) {
        final ListStore<Author> store = author.getStore();

        store.clear();
        store.addAll(authors);
    }

    public void setPresenter(BookPresenter presenter) {
        this.presenter = presenter;
    }

    @UiHandler("save")
    public void saveSelect(SelectEvent event) {
        presenter.handleSave();
    }

    @UiHandler("close")
    public void closeSelect(SelectEvent event) {
        window.hide();
    }

    public String getISBNValue() {
        return ISBN.getCurrentValue();
    }

    public String getTitleValue() {
        return title.getCurrentValue();
    }

    public Author getAuthorValue() {
        return author.getCurrentValue();
    }

    public boolean getEBookValue() {
        return eBook.getValue();
    }

}
