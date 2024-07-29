package com.prueba.libraryservice.adapter.in.web;

import com.prueba.libraryservice.adapter.dtos.CreateBookRequest;
import com.prueba.libraryservice.adapter.dtos.UpdateBookRequest;
import com.prueba.libraryservice.application.facade.BookUseCases;
import com.prueba.libraryservice.domain.commons.Response.Response;
import com.prueba.libraryservice.domain.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookCommandController {

    private final BookUseCases bookUseCases;
    @Autowired
    public BookCommandController(BookUseCases bookUseCases) {
        this.bookUseCases = bookUseCases;
    }


    @GetMapping
    public  ResponseEntity<Response<List<Book>>> getAllBooks(){
        var books = bookUseCases.getGetAllBooksUseCase().getAllBooks();
        return new ResponseEntity<>(new Response<>(null,HttpStatus.OK.value(), books),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Response<Book>> getBookById(@PathVariable Long id){
        var book = bookUseCases.getGetBookByIdUseCase().findBookById(id);
        return new ResponseEntity<>(new Response<>(null,HttpStatus.OK.value(), book),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Response<Book>> createBook(@RequestBody CreateBookRequest request) {

        var book = bookUseCases.getCreateBookUseCase().createBook(request.getTitle(),request.getAuthor_id(),request.getPublisher_id());
        return  new ResponseEntity<>(new Response<Book>(null,HttpStatus.CREATED.value(),book),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Book>> updateBook(@PathVariable Long id, @RequestBody UpdateBookRequest request) {

        var book = bookUseCases.getUpdateBookUseCase().updateBook(id, request.getTitle(), request.getAuthor_id(), request.getPublisher_id());
        return  new ResponseEntity<>(new Response<Book>(null,HttpStatus.OK.value(),book),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deleteBook(@PathVariable Long id) {
        bookUseCases.getDeleteBookUseCase().deleteBook(id);
        return  new ResponseEntity<>(new Response<String>("Book deleted successfully",HttpStatus.OK.value(),null),HttpStatus.OK);
    }
}
