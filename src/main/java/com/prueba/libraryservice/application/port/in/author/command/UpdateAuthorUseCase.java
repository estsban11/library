package com.prueba.libraryservice.application.port.in.author.command;

import com.prueba.libraryservice.domain.entities.Author;

public interface UpdateAuthorUseCase {

    Author updateAuthor(Long id, String name, String lastName);
}
