package com.prueba.libraryservice.config;

import com.prueba.libraryservice.adapter.out.persistence.AuthorCommandRepositoryImpl;
import com.prueba.libraryservice.adapter.out.persistence.BookCommandRepositoryImpl;
import com.prueba.libraryservice.adapter.out.persistence.Credential;
import com.prueba.libraryservice.adapter.out.persistence.PublisherCommandRepository;
import com.prueba.libraryservice.application.port.out.query.BookQueryRepository;
import com.prueba.libraryservice.application.service.*;
import com.prueba.libraryservice.config.jwt.JWTService;
import com.prueba.libraryservice.domain.entities.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfiguration {

    private final Credential credential;

    @Autowired
    public BeanConfiguration(Credential credential) {
        this.credential = credential;
    }

    @Bean
    public BookCommandService bookCommandService(BookCommandRepositoryImpl bookCommandRepository,
                                                 AuthorCommandRepositoryImpl authorCommandRepository,
                                                 PublisherCommandRepository publisherCommandRepository) {
        return new BookCommandService(bookCommandRepository,
                authorCommandRepository,
                publisherCommandRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthorCommandService authorCommandService(AuthorCommandRepositoryImpl authorCommandRepository){
        return  new AuthorCommandService(authorCommandRepository);
    }

    @Bean
    PublisherCommandService publisherCommandService(PublisherCommandRepository publisherCommandRepository){
        return  new PublisherCommandService(publisherCommandRepository);
    }

    @Bean
    PublisherQueryService publisherQueryService(PublisherCommandRepository publisherCommandRepository){
        return new PublisherQueryService(publisherCommandRepository);
    }

    @Bean
    BookQueryService bookQueryService(BookCommandRepositoryImpl bookCommandRepository){
        return  new BookQueryService(bookCommandRepository);
    }

    @Bean
    AuthorQueryService authorQueryService(AuthorCommandRepositoryImpl authorCommandRepository){
        return  new AuthorQueryService(authorCommandRepository);
    }

    @Bean
    JWTService jwtService(){
        return new JWTService();
    }

    @Bean
    public UserDetailsService userDetailService() {
        return username -> credential.findByUsername(username);
    }
    @Bean
    AuthCommandService authCommandService(AuthenticationManager authenticationManager, JWTService jwtService, Credential credential
    ,BCryptPasswordEncoder encoder){
        return new AuthCommandService(authenticationManager,jwtService,credential,encoder);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }




}
