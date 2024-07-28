package com.prueba.libraryservice.application.service;

import com.prueba.libraryservice.adapter.out.persistence.PublisherCommandRepository;
import com.prueba.libraryservice.application.port.in.publisher.command.CreatePublisherUseCase;
import com.prueba.libraryservice.domain.entities.Publisher;

public class PublisherCommandService implements CreatePublisherUseCase {

    private final PublisherCommandRepository publisherCommandService;

    public PublisherCommandService(PublisherCommandRepository publisherCommandService) {
        this.publisherCommandService = publisherCommandService;
    }

    @Override
    public Publisher createPublisher(Publisher publisher) {
        return publisherCommandService.save(publisher);
    }
}
