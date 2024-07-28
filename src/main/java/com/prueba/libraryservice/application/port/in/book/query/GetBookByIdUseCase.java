package com.prueba.libraryservice.application.port.in.book.query;

import com.prueba.libraryservice.domain.entities.Book;

public interface GetBookByIdUseCase {

    Book findBookById(Long id);
}
