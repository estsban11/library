package com.prueba.libraryservice.application.port.in.publisher.query;

import com.prueba.libraryservice.domain.entities.Publisher;

public interface GetPublisherByIdUseCase {

    Publisher getPublisherById(Long id);
}
