package com.prueba.libraryservice.application.facade;

import com.prueba.libraryservice.application.port.in.book.command.CreateBookUseCase;
import com.prueba.libraryservice.application.port.in.book.command.DeleteBookUseCase;
import com.prueba.libraryservice.application.port.in.book.command.UpdateBookUseCase;
import com.prueba.libraryservice.application.port.in.book.query.GetAllBooksUseCase;
import com.prueba.libraryservice.application.port.in.book.query.GetBookByIdUseCase;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class BookUseCases {

    private final CreateBookUseCase createBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final GetAllBooksUseCase getAllBooksUseCase;
    private  final GetBookByIdUseCase getBookByIdUseCase;

    public BookUseCases(CreateBookUseCase createBookUseCase, UpdateBookUseCase updateBookUseCase, DeleteBookUseCase deleteBookUseCase, GetAllBooksUseCase getAllBooksUseCase, GetBookByIdUseCase getBookByIdUseCase) {
        this.createBookUseCase = createBookUseCase;
        this.updateBookUseCase = updateBookUseCase;
        this.deleteBookUseCase = deleteBookUseCase;
        this.getAllBooksUseCase = getAllBooksUseCase;
        this.getBookByIdUseCase = getBookByIdUseCase;
    }



}
