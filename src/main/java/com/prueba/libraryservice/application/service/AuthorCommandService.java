package com.prueba.libraryservice.application.service;

import com.prueba.libraryservice.adapter.out.persistence.AuthorCommandRepositoryImpl;
import com.prueba.libraryservice.application.port.in.author.command.CreateAuthorUseCase;
import com.prueba.libraryservice.application.port.in.author.command.DeleteAuthorUseCase;
import com.prueba.libraryservice.application.port.in.author.command.UpdateAuthorUseCase;
import com.prueba.libraryservice.domain.entities.Author;

import java.util.Optional;

public class AuthorCommandService implements CreateAuthorUseCase, UpdateAuthorUseCase, DeleteAuthorUseCase {

    private final AuthorCommandRepositoryImpl authorCommandRepository;

    public AuthorCommandService(AuthorCommandRepositoryImpl authorCommandRepository) {
        this.authorCommandRepository = authorCommandRepository;
    }

    @Override
    public Author createAuthor(String name, String lastname) {

        Author author = new Author(name,lastname);
        return authorCommandRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {

        Optional<Author> optionalAuthor = authorCommandRepository.findById(id);

        if(optionalAuthor.isEmpty()){
            throw new IllegalArgumentException("There is no author");
        }


        authorCommandRepository.delete(optionalAuthor.get());
    }

    @Override
    public Author updateAuthor(Long id,String name, String lastName) {

        Optional<Author> optionalAuthor = authorCommandRepository.findById(id);

        if(!optionalAuthor.isPresent()){
            throw new IllegalArgumentException("There is no author");
        }

        Author author = optionalAuthor.get();

        author.setName(name);
        author.setLastname(lastName);

        return  authorCommandRepository.save(author);
    }
}
