package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.OrderRequest;
import com.nyller.springmcclean.controller.model.OrderResponse;
import com.nyller.springmcclean.translator.OrderMapper;
import com.nyller.springmcclean.usecase.CreateOrderUsecase;
import com.nyller.springmcclean.usecase.GetOrderByIdUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private CreateOrderUsecase createOrderUsecase;

    @Autowired
    private GetOrderByIdUsecase getOrderByIdUsecase;

    @PostMapping
    public ResponseEntity<Void> createOrder(@Valid @RequestBody OrderRequest orderRequest, UriComponentsBuilder uriComponentsBuilder) {
        var orderMapper = new OrderMapper();
        var order = createOrderUsecase.execute(orderMapper.orderRequestToDomain(orderRequest));

        var uri = uriComponentsBuilder.path("/order/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Integer id) {
        var orderMapper = new OrderMapper();
        var order = getOrderByIdUsecase.execute(id);

        return ResponseEntity.ok().body(orderMapper.orderDomainToResponse(order));
    }
}