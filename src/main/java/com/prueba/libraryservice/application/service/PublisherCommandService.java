package com.prueba.libraryservice.application.service;

import com.prueba.libraryservice.adapter.out.persistence.PublisherCommandRepository;
import com.prueba.libraryservice.application.port.in.publisher.command.CreatePublisherUseCase;
import com.prueba.libraryservice.application.port.in.publisher.command.DeletePublisherUseCase;
import com.prueba.libraryservice.application.port.in.publisher.command.UpdatePublisherUseCase;
import com.prueba.libraryservice.domain.entities.Author;
import com.prueba.libraryservice.domain.entities.Publisher;

import java.util.Optional;

public class PublisherCommandService implements CreatePublisherUseCase, UpdatePublisherUseCase, DeletePublisherUseCase {

    private final PublisherCommandRepository publisherCommandService;

    public PublisherCommandService(PublisherCommandRepository publisherCommandService) {
        this.publisherCommandService = publisherCommandService;
    }

    @Override
    public Publisher createPublisher(String name, String address) {

        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisher.setAddress(address);
        return publisherCommandService.save(publisher);
    }

    @Override
    public void deletePublisher(Long id) {

        Optional<Publisher> optionalPublisher = publisherCommandService.findById(id);

        if(!optionalPublisher.isPresent()){
            throw new IllegalArgumentException("There is no publisher");
        }

        publisherCommandService.delete(optionalPublisher.get());
    }

    @Override
    public Publisher updatePublisher(Long id,String name, String address) {

        Optional<Publisher> optionalPublisher = publisherCommandService.findById(id);

        if(!optionalPublisher.isPresent()){
            throw new IllegalArgumentException("There is no publisher");
        }

        Publisher publisher = optionalPublisher.get();

        publisher.setName(name);
        publisher.setAddress(address);

        publisherCommandService.save(publisher);

        return  publisher;
    }
}
