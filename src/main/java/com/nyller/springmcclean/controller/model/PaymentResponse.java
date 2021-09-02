package com.nyller.springmcclean.controller.model;

import com.nyller.springmcclean.domain.enums.PaymentStatus;
import lombok.Builder;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Builder
public class PaymentResponse implements Serializable {

    private Integer id;
    private Set<String> paymentMethod = new HashSet<>();
    private PaymentStatus paymentStatus;
    private OrderResponse orderResponse;

    public PaymentResponse() {
    }

    public PaymentResponse(Integer id, Set<String> paymentMethod, PaymentStatus paymentStatus, OrderResponse orderResponse) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.orderResponse = orderResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<String> getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Set<String> paymentMethod) {
        this.paymentMethod = paymentMethod;
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