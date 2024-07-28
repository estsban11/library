package com.prueba.libraryservice.application.service;

import com.prueba.libraryservice.adapter.out.persistence.AuthorCommandRepositoryImpl;
import com.prueba.libraryservice.adapter.out.persistence.BookCommandRepositoryImpl;
import com.prueba.libraryservice.adapter.out.persistence.PublisherCommandRepository;
import com.prueba.libraryservice.application.port.in.book.command.CreateBookUseCase;
import com.prueba.libraryservice.domain.entities.Author;
import com.prueba.libraryservice.domain.entities.Book;
import com.prueba.libraryservice.domain.entities.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookCommandService implements CreateBookUseCase {

    private final BookCommandRepositoryImpl bookCommandRepository;
    private final AuthorCommandRepositoryImpl authorRepository;
    private final PublisherCommandRepository publisherRepository;

    @Autowired
    public BookCommandService(BookCommandRepositoryImpl bookCommandRepository, AuthorCommandRepositoryImpl authorRepository,
                              PublisherCommandRepository publisherRepository) {
        this.bookCommandRepository = bookCommandRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Book createBook(String title, Long authorId, Long publisherId) {

        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isEmpty()) {
            throw new IllegalArgumentException("El autor no existe");
        }

        Optional<Publisher> publisher = publisherRepository.findById(publisherId);
        if (publisher.isEmpty()) {
            throw new IllegalArgumentException("El publisher no existe");
        }

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author.get());
        book.setPublisher(publisher.get());

        return bookCommandRepository.save(book);
    }
}
