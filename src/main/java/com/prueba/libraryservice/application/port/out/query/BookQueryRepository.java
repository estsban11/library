package com.prueba.libraryservice.application.port.out.query;

import com.prueba.libraryservice.domain.entities.Book;

public interface BookQueryRepository {

    Book findBookById(Long id);
}
