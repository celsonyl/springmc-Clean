package com.nyller.springmcclean.gateway.h2database.repository;

import com.nyller.springmcclean.gateway.h2database.model.CityDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityDatabase, Integer> {
}