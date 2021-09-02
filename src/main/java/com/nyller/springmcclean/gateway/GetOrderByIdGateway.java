package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.OrderDomain;

import java.util.Optional;

public interface GetOrderByIdGateway {

    Optional<OrderDomain> execute(Integer id);
}