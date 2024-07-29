package com.prueba.libraryservice.application.service;

import com.prueba.libraryservice.adapter.out.persistence.PublisherCommandRepository;
import com.prueba.libraryservice.application.port.in.publisher.query.GetAllPublishersUseCase;
import com.prueba.libraryservice.application.port.in.publisher.query.GetPublisherByIdUseCase;
import com.prueba.libraryservice.domain.entities.Publisher;

import java.util.List;
import java.util.Optional;

public class PublisherQueryService implements GetAllPublishersUseCase, GetPublisherByIdUseCase {

    private final PublisherCommandRepository publisherCommandRepository;

    public PublisherQueryService(PublisherCommandRepository publisherCommandRepository) {
        this.publisherCommandRepository = publisherCommandRepository;
    }

    @Override
    public List<Publisher> getAllPublishers() {

        return publisherCommandRepository.findAll();
    }

    @Override
    public Publisher getPublisherById(Long id) {
        Optional<Publisher> optionalPublisher = publisherCommandRepository.findById(id);

        if(optionalPublisher.isEmpty()){
            throw new IllegalArgumentException("There is no publisher");
        }

        return optionalPublisher.get();
    }
}
