package com.prueba.libraryservice.application.port.in.author.query;

import com.prueba.libraryservice.domain.entities.Author;

import java.util.List;

public interface GetAllAuthorsUseCase {

    List<Author> getAllAuthors();
}
