package com.nyller.springmcclean.gateway.mysql;

import com.nyller.springmcclean.domain.OrderDomain;
import com.nyller.springmcclean.gateway.CreateOrderGateway;
import com.nyller.springmcclean.gateway.mysql.repository.OrderRepository;
import com.nyller.springmcclean.translator.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderGatewayImpl implements CreateOrderGateway {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDomain execute(OrderDomain orderDomain) {
        var orderMapper = new OrderMapper();
        var order = orderRepository.save(orderMapper.orderDomainToDabatase(orderDomain));

        return orderMapper.orderDataseToDomain(order);
    }
}