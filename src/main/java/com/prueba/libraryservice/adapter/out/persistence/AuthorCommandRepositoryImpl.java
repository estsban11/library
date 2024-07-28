package com.prueba.libraryservice.adapter.out.persistence;

import com.prueba.libraryservice.application.port.out.command.AuthorCommandRepository;
import com.prueba.libraryservice.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorCommandRepositoryImpl extends JpaRepository<Author, Long> {


}
