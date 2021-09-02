package com.nyller.springmcclean.domain;

import com.nyller.springmcclean.domain.enums.PaymentStatus;
import lombok.Builder;

import java.io.Serializable;

@Builder
public class PaymentDomain implements Serializable {

    private Integer id;
    private OrderDomain orderId;
    private PaymentStatus paymentStatus;

    public PaymentDomain() {
    }

    public PaymentDomain(Integer id, OrderDomain orderId, PaymentStatus paymentStatus) {
        this.id = id;
        this.orderId = orderId;
        this.paymentStatus = paymentStatus;
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
}