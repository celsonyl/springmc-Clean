package com.nyller.springmcclean.gateway.mysql.repository;

import com.nyller.springmcclean.gateway.mysql.model.ItemOrderDatabase;
import com.nyller.springmcclean.gateway.mysql.model.ItemOrderPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrderDatabase, ItemOrderPK> {
}
