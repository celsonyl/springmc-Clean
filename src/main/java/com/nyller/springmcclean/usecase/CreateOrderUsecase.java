package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.OrderDomain;
import com.nyller.springmcclean.gateway.CreateOrderGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderUsecase {

    @Autowired
    private CreateOrderGateway orderGateway;

    public OrderDomain execute(OrderDomain orderDomain) {
        return orderGateway.execute(orderDomain);
    }
}