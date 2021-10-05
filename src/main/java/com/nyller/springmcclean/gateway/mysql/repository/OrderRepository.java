package com.nyller.springmcclean.gateway.mysql.repository;

import com.nyller.springmcclean.gateway.mysql.model.OrderDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderDatabase, Integer> {

    @Query(nativeQuery = true)
    List<OrderDatabase> findAllByClientDatabaseId(Integer id);
}