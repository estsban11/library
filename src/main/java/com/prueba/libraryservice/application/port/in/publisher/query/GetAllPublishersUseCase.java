package com.prueba.libraryservice.application.port.in.publisher.query;

import com.prueba.libraryservice.domain.entities.Publisher;

import java.util.List;

public interface GetAllPublishersUseCase {

    List<Publisher> getAllPublishers();
}
