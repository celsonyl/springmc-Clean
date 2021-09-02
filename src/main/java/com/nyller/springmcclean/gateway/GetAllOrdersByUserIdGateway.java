package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.OrderDomain;

import java.util.List;

public interface GetAllOrdersByUserIdGateway {

    List<OrderDomain> execute(Integer id);
}