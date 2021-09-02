package com.nyller.springmcclean.domain;

import com.nyller.springmcclean.domain.enums.PaymentStatus;
import lombok.Builder;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Builder
public class PaymentDomain implements Serializable {

    private Integer id;
    private OrderDomain orderId;
    private PaymentStatus paymentStatus;
    private Set<String> paymentMethod = new HashSet<>();

    public PaymentDomain() {
    }

    public PaymentDomain(Integer id, OrderDomain orderId, PaymentStatus paymentStatus, Set<String> paymentMethod) {
        this.id = id;
        this.orderId = orderId;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderDomain getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderDomain orderId) {
        this.orderId = orderId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Set<String> getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Set<String> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}