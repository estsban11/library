package com.prueba.libraryservice.application.port.in.book.command;

import com.prueba.libraryservice.domain.entities.Book;

public interface UpdateBookUseCase {

    Book updateBook(Long id, String title, Long authorId, Long publisherId);
}
