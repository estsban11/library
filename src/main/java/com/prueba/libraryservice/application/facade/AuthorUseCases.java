package com.prueba.libraryservice.application.facade;

import com.prueba.libraryservice.application.port.in.author.command.CreateAuthorUseCase;
import com.prueba.libraryservice.application.port.in.author.command.DeleteAuthorUseCase;
import com.prueba.libraryservice.application.port.in.author.command.UpdateAuthorUseCase;
import com.prueba.libraryservice.application.port.in.author.query.GetAllAuthorsUseCase;
import com.prueba.libraryservice.application.port.in.author.query.GetAuthorByIdUseCase;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AuthorUseCases {

    private final CreateAuthorUseCase createAuthorUseCase;
    private  final UpdateAuthorUseCase updateAuthorUseCase;
    private final DeleteAuthorUseCase deleteAuthorUseCase;
    private final GetAllAuthorsUseCase getAllAuthorsUseCase;
    private final GetAuthorByIdUseCase getAuthorByIdUseCase;

    public AuthorUseCases(CreateAuthorUseCase createAuthorUseCase, UpdateAuthorUseCase updateAuthorUseCase, DeleteAuthorUseCase deleteAuthorUseCase, GetAllAuthorsUseCase getAllAuthorsUseCase, GetAuthorByIdUseCase getAuthorByIdUseCase) {
        this.createAuthorUseCase = createAuthorUseCase;
        this.updateAuthorUseCase = updateAuthorUseCase;
        this.deleteAuthorUseCase = deleteAuthorUseCase;
        this.getAllAuthorsUseCase = getAllAuthorsUseCase;
        this.getAuthorByIdUseCase = getAuthorByIdUseCase;
    }
}
