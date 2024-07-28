package com.prueba.libraryservice.adapter.in.web;

import com.prueba.libraryservice.adapter.dtos.CreateBookRequest;
import com.prueba.libraryservice.application.port.in.book.command.CreateBookUseCase;
import com.prueba.libraryservice.domain.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookCommandController {

    private final CreateBookUseCase createBookUseCase;
    @Autowired
    public BookCommandController(CreateBookUseCase createBookUseCase) {
        this.createBookUseCase = createBookUseCase;
    }


    @PostMapping
    public Book createBook(@RequestBody CreateBookRequest request) {

        return createBookUseCase.createBook(request.getTitle(),request.getAuthor_id(),request.getPublisher_id());
    }
}
