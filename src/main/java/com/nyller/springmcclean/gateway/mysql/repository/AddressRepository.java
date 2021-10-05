package com.nyller.springmcclean.gateway.mysql.repository;

import com.nyller.springmcclean.gateway.mysql.model.AddressDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressDatabase, Integer> {
}