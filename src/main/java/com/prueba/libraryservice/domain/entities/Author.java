package com.prueba.libraryservice.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.prueba.libraryservice.domain.entities.base.baseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Author extends baseEntity {
    private String name;
    private String lastname;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Book> books;

    public Author(){}
    public Author(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
