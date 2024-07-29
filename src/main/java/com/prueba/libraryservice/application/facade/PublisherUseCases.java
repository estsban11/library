package com.prueba.libraryservice.application.facade;

import com.prueba.libraryservice.application.port.in.publisher.command.CreatePublisherUseCase;
import com.prueba.libraryservice.application.port.in.publisher.command.DeletePublisherUseCase;
import com.prueba.libraryservice.application.port.in.publisher.command.UpdatePublisherUseCase;
import com.prueba.libraryservice.application.port.in.publisher.query.GetAllPublishersUseCase;
import com.prueba.libraryservice.application.port.in.publisher.query.GetPublisherByIdUseCase;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PublisherUseCases {

    private final CreatePublisherUseCase createPublisherUseCase;
    private final UpdatePublisherUseCase updatePublisherUseCase;
    private final DeletePublisherUseCase deletePublisherUseCase;
    private final GetAllPublishersUseCase getAllPublishersUseCase;
    private  final GetPublisherByIdUseCase getPublisherByIdUseCase;

    public PublisherUseCases(CreatePublisherUseCase createPublisherUseCase, UpdatePublisherUseCase updatePublisherUseCase, DeletePublisherUseCase deletePublisherUseCase, GetAllPublishersUseCase getAllPublishersUseCase, GetPublisherByIdUseCase getPublisherByIdUseCase) {
        this.createPublisherUseCase = createPublisherUseCase;
        this.updatePublisherUseCase = updatePublisherUseCase;
        this.deletePublisherUseCase = deletePublisherUseCase;
        this.getAllPublishersUseCase = getAllPublishersUseCase;
        this.getPublisherByIdUseCase = getPublisherByIdUseCase;
    }
}
