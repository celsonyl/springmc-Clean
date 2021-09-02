package com.nyller.springmcclean.controller.model;

import com.nyller.springmcclean.domain.enums.PaymentStatus;
import lombok.Builder;

import java.io.Serializable;

@Builder
public class PaymentResponse implements Serializable {

    private Integer id;
    private PaymentStatus paymentStatus;
    private OrderResponse orderResponse;

    public PaymentResponse() {
    }

    public PaymentResponse(Integer id, PaymentStatus paymentStatus, OrderResponse orderResponse) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.orderResponse = orderResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public OrderResponse getOrderResponse() {
        return orderResponse;
    }

    public void setOrderResponse(OrderResponse orderResponse) {
        this.orderResponse = orderResponse;
    }
}