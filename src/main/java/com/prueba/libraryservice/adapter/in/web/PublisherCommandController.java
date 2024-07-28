package com.prueba.libraryservice.adapter.in.web;

import com.prueba.libraryservice.application.port.in.publisher.command.CreatePublisherUseCase;
import com.prueba.libraryservice.domain.entities.Publisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publisher")
public class PublisherCommandController {

    private final CreatePublisherUseCase createPublisherUseCase;

    public PublisherCommandController(CreatePublisherUseCase createPublisherUseCase) {
        this.createPublisherUseCase = createPublisherUseCase;
    }

    @PostMapping
    public Publisher createPublisher(@RequestBody Publisher publisher){
        return  createPublisherUseCase.createPublisher(publisher);
    }
}
