package com.nyller.springmcclean.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

@Builder
public class OrderRequest implements Serializable {

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm", timezone = "GMT-3")
    private Date instant;
    private ClientRequest clientRequest;
    private AddressRequest addressRequest;

    public OrderRequest() {
    }

    public OrderRequest(Integer id, Date instant, ClientRequest clientRequest, AddressRequest addressRequest) {
        this.id = id;
        this.instant = instant;
        this.clientRequest = clientRequest;
        this.addressRequest = addressRequest;
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

    public ClientRequest getClientRequest() {
        return clientRequest;
    }

    public void setClientRequest(ClientRequest clientRequest) {
        this.clientRequest = clientRequest;
    }

    public AddressRequest getAddressRequest() {
        return addressRequest;
    }

    public void setAddressRequest(AddressRequest addressRequest) {
        this.addressRequest = addressRequest;
    }
}