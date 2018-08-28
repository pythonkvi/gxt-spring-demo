package com.example.gxtspringdemo.shared.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Book implements Serializable {
    @Id
    @Column(length = 20)
    @JsonProperty
    @NotNull(message = "ISBN can't be empty")
    private String isbn;

    @Column(nullable = false, length = 200)
    @JsonProperty
    @NotNull(message = "Title can't be empty")
    @Size(min=1, max=200, message = "Title can't be larger than 200")
    private String title;

    @ManyToOne
    @NotNull(message = "Author can't be empty")
    private Author author;

    @Column
    private boolean eBook;

    @Temporal(TemporalType.DATE)
    @Column
    private Date dateAdd;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", eBook=" + eBook +
                ", dateAdd=" + dateAdd +
                '}';
    }
}
