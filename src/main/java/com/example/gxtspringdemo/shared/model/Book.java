package com.example.gxtspringdemo.shared.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Strings;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Book implements Serializable {
    @Id
    @Column(length = 20)
    @JsonProperty
    private String ISBN;

    @Column(nullable = false, length = 200)
    @JsonProperty
    private String title;

    @ManyToOne
    private Author author;

    @Column
    private boolean eBook;

    @Temporal(TemporalType.DATE)
    @Column
    private Date dateAdd;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @JsonIgnore
    public String getiSBN() {
        return getISBN();
    }

    public void setiSBN(String ISBN) {
        this.setISBN(ISBN);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean iseBook() {
        return eBook;
    }

    public void seteBook(boolean eBook) {
        this.eBook = eBook;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", eBook=" + eBook +
                ", dateAdd=" + dateAdd +
                '}';
    }
}
