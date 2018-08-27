package com.example.gxtspringdemo.client.author;

import com.example.gxtspringdemo.shared.model.Author;
import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface AuthorProp extends PropertyAccess<Author> {
    @Editor.Path("id")
    ModelKeyProvider<Author> key();

    @Editor.Path("FIO")
    LabelProvider<Author> label();
}
