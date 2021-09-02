package com.nyller.springmcclean.domain;

import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

@Builder
public class OrderDomain implements Serializable {

    private Integer id;
    private Date instant;
    private ClientDomain clientDomain;
    private AddressDomain addressDomain;

    public OrderDomain() {
    }

    public OrderDomain(Integer id, Date instant, ClientDomain clientDomain, AddressDomain addressDomain) {
        this.id = id;
        this.instant = instant;
        this.clientDomain = clientDomain;
        this.addressDomain = addressDomain;
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

    public ClientDomain getClientDomain() {
        return clientDomain;
    }

    public void setClientDomain(ClientDomain clientDomain) {
        this.clientDomain = clientDomain;
    }

    public AddressDomain getAddressDomain() {
        return addressDomain;
    }

    public void setAddressDomain(AddressDomain addressDomain) {
        this.addressDomain = addressDomain;
    }
}