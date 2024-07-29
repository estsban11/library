package com.prueba.libraryservice.application.port.in.publisher.command;

import com.prueba.libraryservice.domain.entities.Publisher;

public interface UpdatePublisherUseCase {

    Publisher updatePublisher(Long id,String name, String address );
}
