package com.nyller.springmcclean.gateway.h2database.model;

import com.nyller.springmcclean.domain.enums.PaymentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "payments")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PaymentDatabase implements Serializable {

    @Id
    private Integer id;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToOne
    @JoinColumn(name = "order_id")
    @MapsId
    private OrderDatabase orderDatabase;

    public PaymentDatabase() {
    }

    public PaymentDatabase(Integer id, PaymentStatus paymentStatus, OrderDatabase orderDatabase) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.orderDatabase = orderDatabase;
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

    public OrderDatabase getOrderDatabase() {
        return orderDatabase;
    }

    public void setOrderDatabase(OrderDatabase orderDatabase) {
        this.orderDatabase = orderDatabase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDatabase that = (PaymentDatabase) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}