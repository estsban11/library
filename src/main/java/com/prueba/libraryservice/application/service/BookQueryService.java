package com.prueba.libraryservice.application.service;


import com.prueba.libraryservice.adapter.out.persistence.BookCommandRepositoryImpl;
import com.prueba.libraryservice.application.port.in.book.query.GetAllBooksUseCase;
import com.prueba.libraryservice.application.port.in.book.query.GetBookByIdUseCase;
import com.prueba.libraryservice.domain.entities.Book;

import java.util.List;
import java.util.Optional;

public class BookQueryService implements GetBookByIdUseCase, GetAllBooksUseCase {

    private  final BookCommandRepositoryImpl bookCommandRepository;

    public BookQueryService(BookCommandRepositoryImpl bookCommandRepository) {
        this.bookCommandRepository = bookCommandRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookCommandRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) {

        Optional<Book> optionalBook = bookCommandRepository.findById(id);

        if(optionalBook.isEmpty()){
            throw new IllegalArgumentException("There is no book");
        }

        return optionalBook.get();
    }
}
