package com.example.gxtspringdemo.shared.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Strings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Author implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    @JsonProperty
    private int id;

    @Column(length = 100)
    private String lastName;

    @Column(length = 100)
    private String middleName;

    @Column(length = 100)
    private String firstName;

    @Column
    private int birthYear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @JsonProperty
    public String getFIO() {
        return getLastName() + " " +
                getFirstCapitalize(getFirstName()) + " " +
                getFirstCapitalize(getMiddleName());
    }

    private String getFirstCapitalize(String s) {
        return Strings.isNullOrEmpty(s) ? "" : s.substring(0, 1).toUpperCase() + ".";
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}
