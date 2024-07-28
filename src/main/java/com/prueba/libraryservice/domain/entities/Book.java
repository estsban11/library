package com.prueba.libraryservice.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.prueba.libraryservice.domain.entities.base.baseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book extends baseEntity {
    private  String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonManagedReference
    private Author author;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @JsonManagedReference
    private Publisher publisher;



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

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
