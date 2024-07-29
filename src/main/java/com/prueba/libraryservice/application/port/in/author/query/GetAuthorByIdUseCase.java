package com.prueba.libraryservice.application.port.in.author.query;

import com.prueba.libraryservice.domain.entities.Author;

public interface GetAuthorByIdUseCase {

    Author getAuthorById(Long id);
}
