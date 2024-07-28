package com.prueba.libraryservice.config;

import com.prueba.libraryservice.adapter.out.persistence.AuthorCommandRepositoryImpl;
import com.prueba.libraryservice.adapter.out.persistence.BookCommandRepositoryImpl;
import com.prueba.libraryservice.adapter.out.persistence.PublisherCommandRepository;
import com.prueba.libraryservice.application.service.AuthorCommandService;
import com.prueba.libraryservice.application.service.BookCommandService;
import com.prueba.libraryservice.application.service.PublisherCommandService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public BookCommandService bookCommandService(BookCommandRepositoryImpl bookCommandRepository,
                                                 AuthorCommandRepositoryImpl authorCommandRepository,
                                                 PublisherCommandRepository publisherCommandRepository) {
        return new BookCommandService(bookCommandRepository,
                authorCommandRepository,
                publisherCommandRepository);
    }

    @Bean
    AuthorCommandService authorCommandService(AuthorCommandRepositoryImpl authorCommandRepository){
        return  new AuthorCommandService(authorCommandRepository);
    }

    @Bean
    PublisherCommandService publisherCommandService(PublisherCommandRepository publisherCommandRepository){
        return  new PublisherCommandService(publisherCommandRepository);
    }
}
