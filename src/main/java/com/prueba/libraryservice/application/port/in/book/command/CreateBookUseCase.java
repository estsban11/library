package com.prueba.libraryservice.application.port.in.book.command;

import com.prueba.libraryservice.domain.entities.Book;

public interface CreateBookUseCase {

    Book createBook(String title, String image, Long authorId, Long publisherId);
}
