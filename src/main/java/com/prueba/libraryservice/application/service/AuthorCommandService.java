package com.prueba.libraryservice.application.service;

import com.prueba.libraryservice.adapter.out.persistence.AuthorCommandRepositoryImpl;
import com.prueba.libraryservice.application.port.in.author.command.CreateAuthorUseCase;
import com.prueba.libraryservice.domain.entities.Author;

public class AuthorCommandService implements CreateAuthorUseCase {

    private final AuthorCommandRepositoryImpl authorCommandRepository;

    public AuthorCommandService(AuthorCommandRepositoryImpl authorCommandRepository) {
        this.authorCommandRepository = authorCommandRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorCommandRepository.save(author);
    }
}
