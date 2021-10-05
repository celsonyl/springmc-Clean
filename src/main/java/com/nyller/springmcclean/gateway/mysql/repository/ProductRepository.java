package com.nyller.springmcclean.gateway.mysql.repository;

import com.nyller.springmcclean.gateway.mysql.model.ProductDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDatabase,Integer> {
}
