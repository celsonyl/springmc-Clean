package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.OrderDomain;
import com.nyller.springmcclean.gateway.GetOrderByIdGateway;
import com.nyller.springmcclean.gateway.h2database.repository.OrderRepository;
import com.nyller.springmcclean.translator.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetOrderByIdGatewayImpl implements GetOrderByIdGateway {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Optional<OrderDomain> execute(Integer id) {
        var orderMapper = new OrderMapper();
        var order = orderRepository.findById(id);

        if (order.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(orderMapper.orderDataseToDomainGetById(order.get()));
    }
}