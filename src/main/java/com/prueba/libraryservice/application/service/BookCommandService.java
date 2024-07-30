package com.prueba.libraryservice.application.service;

import com.prueba.libraryservice.adapter.out.persistence.AuthorCommandRepositoryImpl;
import com.prueba.libraryservice.adapter.out.persistence.BookCommandRepositoryImpl;
import com.prueba.libraryservice.adapter.out.persistence.PublisherCommandRepository;
import com.prueba.libraryservice.application.port.in.book.command.CreateBookUseCase;
import com.prueba.libraryservice.application.port.in.book.command.DeleteBookUseCase;
import com.prueba.libraryservice.application.port.in.book.command.UpdateBookUseCase;
import com.prueba.libraryservice.domain.entities.Author;
import com.prueba.libraryservice.domain.entities.Book;
import com.prueba.libraryservice.domain.entities.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class BookCommandService implements CreateBookUseCase, UpdateBookUseCase, DeleteBookUseCase {

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
    public Book createBook(String title, String image, Long authorId, Long publisherId) {

        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isEmpty()) {
            throw new IllegalArgumentException("There is no author");
        }

        Optional<Publisher> publisher = publisherRepository.findById(publisherId);
        if (publisher.isEmpty()) {
            throw new IllegalArgumentException("There is no publisher");
        }

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author.get());
        book.setPublisher(publisher.get());
        book.setImage(image);
        book.setPublication_date(new Date());

        return bookCommandRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, String title, Long authorId, Long publisherId) {
        Optional<Book> bookOptional = bookCommandRepository.findById(id);
        if (bookOptional.isEmpty()) {
            throw new IllegalArgumentException("There is no book");
        }

        Book book = bookOptional.get();

        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isEmpty()) {
            throw new IllegalArgumentException("There is no author");
        }


        Optional<Publisher> publisher = publisherRepository.findById(publisherId);
        if (publisher.isEmpty()) {
            throw new IllegalArgumentException("There is no publisher");
        }


        book.setTitle(title);
        book.setAuthor(author.get());
        book.setPublisher(publisher.get());

        return bookCommandRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {

        Optional<Book> bookOptional = bookCommandRepository.findById(id);
        if(bookOptional.isEmpty()){
            throw new IllegalArgumentException("There is no book");
        }

        bookCommandRepository.delete(bookOptional.get());
    }
}
