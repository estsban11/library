package com.prueba.libraryservice.application.port.in.author.command;

import com.prueba.libraryservice.domain.entities.Author;

public interface CreateAuthorUseCase {

    Author createAuthor(Author author);
}
