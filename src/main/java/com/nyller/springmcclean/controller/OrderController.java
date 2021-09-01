package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.OrderRequest;
import com.nyller.springmcclean.translator.OrderMapper;
import com.nyller.springmcclean.usecase.CreateOrderUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private CreateOrderUsecase createOrderUsecase;

    @PostMapping
    public ResponseEntity<Void> createOrder(@Valid @RequestBody OrderRequest orderRequest, UriComponentsBuilder uriComponentsBuilder) {
        var orderMapper = new OrderMapper();
        var order = createOrderUsecase.execute(orderMapper.orderRequestToDomain(orderRequest));

        var uri = uriComponentsBuilder.path("/order/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}