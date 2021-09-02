package com.nyller.springmcclean.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

@Builder
public class OrderResponse implements Serializable {

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm", timezone = "GMT-3")
    private Date instant;
    private ClientResponseAddress clientResponseAddress;
    private AddressResponseGetAll addressResponseGetAll;

    public OrderResponse() {
    }

    public OrderResponse(Integer id, Date instant, ClientResponseAddress clientResponseAddress, AddressResponseGetAll addressResponseGetAll) {
        this.id = id;
        this.instant = instant;
        this.clientResponseAddress = clientResponseAddress;
        this.addressResponseGetAll = addressResponseGetAll;
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

    public ClientResponseAddress getClientResponseAddress() {
        return clientResponseAddress;
    }

    public void setClientResponseAddress(ClientResponseAddress clientResponseAddress) {
        this.clientResponseAddress = clientResponseAddress;
    }

    public AddressResponseGetAll getAddressResponseGetAll() {
        return addressResponseGetAll;
    }

    public void setAddressResponseGetAll(AddressResponseGetAll addressResponseGetAll) {
        this.addressResponseGetAll = addressResponseGetAll;
    }
}