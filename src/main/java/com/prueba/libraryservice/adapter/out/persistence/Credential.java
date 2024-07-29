package com.prueba.libraryservice.adapter.out.persistence;

import com.prueba.libraryservice.domain.entities.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface Credential extends JpaRepository<CredentialEntity,Long> {

    UserDetails findByUsername(String username);
}
