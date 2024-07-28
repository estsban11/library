package com.prueba.libraryservice.application.port.out.command;

import com.prueba.libraryservice.domain.entities.Book;

public interface BookCommandRepository {

    Book save(Book book);
}
