package com.prueba.libraryservice.application.port.in.publisher.command;

import com.prueba.libraryservice.domain.entities.Publisher;

public interface CreatePublisherUseCase {

    Publisher createPublisher(Publisher publisher);
}
