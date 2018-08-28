package com.example.gxtspringdemo.client;

import com.example.gxtspringdemo.shared.model.Book;
import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;

import javax.validation.Validator;

public class GwtHibernateValidatorFactory extends AbstractGwtValidatorFactory {
    @Override
    public AbstractGwtValidator createValidator() {
        return GWT.create(GwtBookValidator.class);
    }

    @GwtValidation(value = {Book.class}, groups = {GwtValidationWarning.class})
    public interface GwtBookValidator extends Validator {
    }
}
