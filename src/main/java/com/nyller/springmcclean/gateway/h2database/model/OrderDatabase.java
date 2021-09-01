package com.nyller.springmcclean.gateway.h2database.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity(name = "orders")
@Builder
public class OrderDatabase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm",timezone = "GMT-3")
    private Date instant;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orderDatabase")
    private PaymentDatabase paymentDatabase;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientDatabase clientDatabase;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressDatabase addressDatabase;

    public OrderDatabase() {
    }

    public OrderDatabase(Integer id, Date instant, PaymentDatabase paymentDatabase, ClientDatabase clientDatabase, AddressDatabase addressDatabase) {
        this.id = id;
        this.instant = instant;
        this.paymentDatabase = paymentDatabase;
        this.clientDatabase = clientDatabase;
        this.addressDatabase = addressDatabase;
    }

    public OrderDatabase(Integer id, Date instant, ClientDatabase clientDatabase, AddressDatabase addressDatabase) {
        this.id = id;
        this.instant = instant;
        this.clientDatabase = clientDatabase;
        this.addressDatabase = addressDatabase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstant() {
        return instant;
    }

    public void setInstant(Date instant) {
        this.instant = instant;
    }

    public PaymentDatabase getPaymentDatabase() {
        return paymentDatabase;
    }

    public void setPaymentDatabase(PaymentDatabase paymentDatabase) {
        this.paymentDatabase = paymentDatabase;
    }

    public ClientDatabase getClientDatabase() {
        return clientDatabase;
    }

    public void setClientDatabase(ClientDatabase clientDatabase) {
        this.clientDatabase = clientDatabase;
    }

    public AddressDatabase getAddressDatabase() {
        return addressDatabase;
    }

    public void setAddressDatabase(AddressDatabase addressDatabase) {
        this.addressDatabase = addressDatabase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDatabase that = (OrderDatabase) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}