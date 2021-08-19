package com.nyller.springmcclean.controller.model;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class AddressRequest implements Serializable {

    private Integer id;
    private String logradouro;
    private String number;
    private String complemento;
    private String bairro;
    private String cep;

    private ClientRequest clientRequest;

    private CityRequest cityRequest;

    public AddressRequest() {
    }

    public AddressRequest(Integer id, String logradouro, String number,
                          String complemento, String bairro, String cep, ClientRequest clientRequest, CityRequest cityRequest) {
        this.id = id;
        this.logradouro = logradouro;
        this.number = number;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.clientRequest = clientRequest;
        this.cityRequest = cityRequest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public ClientRequest getClientRequest() {
        return clientRequest;
    }

    public void setClientRequest(ClientRequest clientRequest) {
        this.clientRequest = clientRequest;
    }

    public CityRequest getCityRequest() {
        return cityRequest;
    }

    public void setCityRequest(CityRequest cityRequest) {
        this.cityRequest = cityRequest;
    }
}