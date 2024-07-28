package com.prueba.libraryservice.adapter.in.web;

import com.prueba.libraryservice.application.port.in.author.command.CreateAuthorUseCase;
import com.prueba.libraryservice.domain.entities.Author;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorCommandController {

    private final CreateAuthorUseCase createAuthorUseCase;

    public AuthorCommandController(CreateAuthorUseCase createAuthorUseCase) {
        this.createAuthorUseCase = createAuthorUseCase;
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return  createAuthorUseCase.createAuthor(author);
    }
}
