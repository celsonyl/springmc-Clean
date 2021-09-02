package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.OrderDomain;
import com.nyller.springmcclean.gateway.GetAllOrdersByUserIdGateway;
import com.nyller.springmcclean.gateway.h2database.repository.OrderRepository;
import com.nyller.springmcclean.translator.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllOrdersByUserIdGatewayImpl implements GetAllOrdersByUserIdGateway {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDomain> execute(Integer id) {
        var orderMapper = new OrderMapper();
        var orderList = orderRepository.findAllByClientDatabaseId(id);

        return orderList.stream()
                .map(orderMapper::orderDataseToDomainGetById)
                .collect(Collectors.toList());
    }
}