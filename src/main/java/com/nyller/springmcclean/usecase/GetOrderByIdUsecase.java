package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.OrderDomain;
import com.nyller.springmcclean.domain.exceptions.ObjectNotFoundException;
import com.nyller.springmcclean.gateway.GetOrderByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetOrderByIdUsecase {

    @Autowired
    private GetOrderByIdGateway getOrderByIdGateway;

    public OrderDomain execute(Integer id) {
        return getOrderByIdGateway.execute(id)
                .orElseThrow(() -> new ObjectNotFoundException("Order not found! " + id));
    }
}