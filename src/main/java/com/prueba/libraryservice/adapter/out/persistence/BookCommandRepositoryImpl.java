package com.prueba.libraryservice.adapter.out.persistence;

import com.prueba.libraryservice.application.port.out.command.BookCommandRepository;
import com.prueba.libraryservice.domain.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCommandRepositoryImpl extends JpaRepository<Book, Long> {


}
