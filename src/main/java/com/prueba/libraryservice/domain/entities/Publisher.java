package com.prueba.libraryservice.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.prueba.libraryservice.domain.entities.base.baseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Publisher extends baseEntity {

    private String name;
    private String address;
    @OneToMany(mappedBy = "publisher",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Book> books;

    public Publisher(){}
    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
