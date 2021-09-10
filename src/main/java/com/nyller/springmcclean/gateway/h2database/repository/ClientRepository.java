package com.nyller.springmcclean.gateway.h2database.repository;

import com.nyller.springmcclean.gateway.h2database.model.ClientDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientRepository extends JpaRepository<ClientDatabase, Integer> {

    @Transactional(readOnly = true)
    ClientDatabase findByEmail(String email);
}