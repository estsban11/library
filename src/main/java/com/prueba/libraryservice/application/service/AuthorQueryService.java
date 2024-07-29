package com.prueba.libraryservice.application.service;

import com.prueba.libraryservice.adapter.out.persistence.AuthorCommandRepositoryImpl;
import com.prueba.libraryservice.application.port.in.author.query.GetAllAuthorsUseCase;
import com.prueba.libraryservice.application.port.in.author.query.GetAuthorByIdUseCase;
import com.prueba.libraryservice.domain.entities.Author;
import com.prueba.libraryservice.domain.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorQueryService implements GetAllAuthorsUseCase, GetAuthorByIdUseCase {

    private final AuthorCommandRepositoryImpl authorCommandRepository;

    public AuthorQueryService(AuthorCommandRepositoryImpl authorCommandRepository) {
        this.authorCommandRepository = authorCommandRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return  authorCommandRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {


        Optional<Author> optionalAuthor = authorCommandRepository.findById(id);

        if(optionalAuthor.isEmpty()){
            throw new IllegalArgumentException("There is no author");
        }

        return optionalAuthor.get();
    }
}
