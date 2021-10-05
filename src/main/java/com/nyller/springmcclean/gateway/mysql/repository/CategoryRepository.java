package com.nyller.springmcclean.gateway.mysql.repository;

import com.nyller.springmcclean.gateway.mysql.model.CategoryDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDatabase,Integer> {
}
