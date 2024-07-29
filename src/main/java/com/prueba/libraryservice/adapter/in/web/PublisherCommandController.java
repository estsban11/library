package com.prueba.libraryservice.adapter.in.web;

import com.prueba.libraryservice.adapter.dtos.CreatePublisherRequest;
import com.prueba.libraryservice.adapter.dtos.UpdateAuthorRequest;
import com.prueba.libraryservice.adapter.dtos.UpdatePublisherRequest;
import com.prueba.libraryservice.application.facade.PublisherUseCases;
import com.prueba.libraryservice.application.port.in.publisher.command.CreatePublisherUseCase;
import com.prueba.libraryservice.domain.commons.Response.Response;
import com.prueba.libraryservice.domain.entities.Author;
import com.prueba.libraryservice.domain.entities.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherCommandController {

    private final PublisherUseCases publisherUseCases;

    public PublisherCommandController(PublisherUseCases publisherUseCases) {
        this.publisherUseCases = publisherUseCases;
    }

    @GetMapping
    public  ResponseEntity<Response<List<Publisher>>> getAllPublisher(){
        var publishers = publisherUseCases.getGetAllPublishersUseCase().getAllPublishers();
        return new ResponseEntity<>(new Response<>(null,HttpStatus.OK.value(), publishers),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Response<Publisher>> getPublisherById(@PathVariable Long id){
        var publisher = publisherUseCases.getGetPublisherByIdUseCase().getPublisherById(id);
        return new ResponseEntity<>(new Response<>(null,HttpStatus.OK.value(), publisher),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Response<Publisher>> createPublisher(@RequestBody CreatePublisherRequest publisher){
        var newPublisher = publisherUseCases.getCreatePublisherUseCase().createPublisher(publisher.getName(),publisher.getAddress());
        return new ResponseEntity<>(new Response<>(null, HttpStatus.CREATED.value(),newPublisher),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Publisher>> updatePublisher(@PathVariable Long id, @RequestBody UpdatePublisherRequest request) {

        var publisher = publisherUseCases.getUpdatePublisherUseCase().updatePublisher(id, request.getName(),request.getAddress());
        return  new ResponseEntity<>(new Response<>(null,HttpStatus.OK.value(),publisher),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deletePublisher(@PathVariable Long id) {
        publisherUseCases.getDeletePublisherUseCase().deletePublisher(id);
        return  new ResponseEntity<>(new Response<String>("Publisher deleted successfully",HttpStatus.OK.value(),null),HttpStatus.OK);
    }
}
