package com.prueba.libraryservice.application.port.in.book.query;

import com.prueba.libraryservice.domain.entities.Book;

import java.util.List;

public interface GetAllBooksUseCase {

    List<Book> getAllBooks();
}
