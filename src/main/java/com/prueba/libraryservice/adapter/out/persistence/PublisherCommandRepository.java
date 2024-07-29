package com.prueba.libraryservice.adapter.out.persistence;

import com.prueba.libraryservice.domain.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherCommandRepository extends JpaRepository<Publisher,Long> {
}
