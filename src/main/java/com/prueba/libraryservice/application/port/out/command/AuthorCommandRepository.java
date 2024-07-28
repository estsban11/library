package com.prueba.libraryservice.application.port.out.command;

import com.prueba.libraryservice.domain.entities.Author;

public interface AuthorCommandRepository {

    Author saveAuthor(Author author);
}
