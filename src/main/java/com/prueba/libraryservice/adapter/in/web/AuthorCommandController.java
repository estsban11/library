package com.prueba.libraryservice.adapter.in.web;

import com.prueba.libraryservice.adapter.dtos.CreateAuthorRequest;
import com.prueba.libraryservice.application.facade.AuthorUseCases;
import com.prueba.libraryservice.domain.commons.Response.Response;
import com.prueba.libraryservice.domain.entities.Author;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/author")
@Validated
public class AuthorCommandController {

    private final AuthorUseCases authorUseCases;

    public AuthorCommandController(AuthorUseCases authorUseCases) {
        this.authorUseCases = authorUseCases;
    }


    @GetMapping
    public  ResponseEntity<Response<List<Author>>> getAllAuthor(){
        var authors = authorUseCases.getGetAllAuthorsUseCase().getAllAuthors();
        return new ResponseEntity<>(new Response<>(null,HttpStatus.OK.value(), authors),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Response<Author>> getAuthorById(@Valid @PathVariable Long id) throws Exception{
        var author = authorUseCases.getGetAuthorByIdUseCase().getAuthorById(id);
        return new ResponseEntity<>(new Response<>(null,HttpStatus.OK.value(), author),HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Response<Author>> createAuthor(@Valid @RequestBody CreateAuthorRequest author){

        var newAuthor = authorUseCases.getCreateAuthorUseCase().createAuthor(author.getName(),author.getLastname());
        return new ResponseEntity<>(new Response<>(null, HttpStatus.CREATED.value(),newAuthor),HttpStatus.CREATED) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Author>> updateBook(@PathVariable Long id, @Valid @RequestBody CreateAuthorRequest request) {

        var author = authorUseCases.getUpdateAuthorUseCase().updateAuthor(id, request.getName(),request.getLastname());
        return  new ResponseEntity<>(new Response<>(null,HttpStatus.OK.value(),author),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deleteBook(@PathVariable Long id) {
        authorUseCases.getDeleteAuthorUseCase().deleteAuthor(id);
        return  new ResponseEntity<>(new Response<String>("Author deleted successfully",HttpStatus.OK.value(),null),HttpStatus.OK);
    }
}
