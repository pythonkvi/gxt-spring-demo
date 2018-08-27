package com.example.gxtspringdemo.client.book;

import com.example.gxtspringdemo.shared.model.Author;
import com.example.gxtspringdemo.shared.model.Book;
import com.google.common.collect.ImmutableList;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

import java.util.List;

public class BookView implements IsWidget {

    interface BookUiBinder extends UiBinder<VerticalLayoutContainer, BookView> {
    }

    private static BookUiBinder ourUiBinder = GWT.create(BookUiBinder.class);
    private static final BookProp PROPS = GWT.create(BookProp.class);

    private VerticalLayoutContainer container;
    private BookPresenter presenter;

    @UiField(provided = true)
    Grid<Book> bookList;
    @UiField
    TextButton remove;
    @UiField
    TextButton add;

    public BookView() {
        bookList = new Grid<>(new ListStore<Book>(PROPS.key()), new ColumnModel<Book>(ImmutableList.<ColumnConfig<Book, ?>>of(
                new ColumnConfig<Book, String>(PROPS.ISBN(), 200, "ISBN"),
                new ColumnConfig<Book, String>(PROPS.title(), 300, "Title"),
                new ColumnConfig<Book, String>(PROPS.author(), 200, "Author")
        )));

        bookList.setSelectionModel(new CheckBoxSelectionModel<Book>());

        container = ourUiBinder.createAndBindUi(this);
        container.setVisible(false);
    }

    @Override
    public Widget asWidget() {
        return container;
    }

    public void show() {
        container.setVisible(true);
    }

    public void setPresenter(BookPresenter presenter) {
        this.presenter = presenter;
    }

    @UiHandler("add")
    public void addSelect(SelectEvent event) {
        presenter.handleAdd();
    }

    @UiHandler("remove")
    public void removeSelect(SelectEvent event) {
        final ConfirmMessageBox confirmMessageBox = new ConfirmMessageBox("Confirm", "Confirm delete?");
        confirmMessageBox.addDialogHideHandler(new DialogHideEvent.DialogHideHandler() {
            @Override
            public void onDialogHide(DialogHideEvent event) {
                if (Dialog.PredefinedButton.YES.equals(event.getHideButton())) {
                    presenter.handleRemove(bookList.getSelectionModel().getSelectedItems());
                }
            }
        });
        confirmMessageBox.show();
    }

    public void setBookList(List<Book> books) {
        final ListStore<Book> store = bookList.getStore();
        store.clear();
        store.addAll(books);
    }

    interface BookProp extends PropertyAccess<Book> {
        @Editor.Path("ISBN")
        ModelKeyProvider<Book> key();

        ValueProvider<Book, String> ISBN();

        ValueProvider<Book, String> title();

        @Editor.Path("author.FIO")
        ValueProvider<Book, String> author();
    }

}
