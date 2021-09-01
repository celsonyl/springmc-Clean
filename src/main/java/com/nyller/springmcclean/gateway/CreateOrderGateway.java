package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.OrderDomain;

public interface CreateOrderGateway {

    OrderDomain execute(OrderDomain orderDomain);
}