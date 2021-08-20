package com.nyller.springmcclean.controller.model;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class AddressResponseGetAll implements Serializable {

    private Integer id;
    private String logradouro;
    private String number;
    private String complemento;
    private String bairro;
    private String cep;
    private String clientName;
    private String cityName;

    public AddressResponseGetAll() {
    }

    public AddressResponseGetAll(Integer id, String logradouro, String number, String complemento, String bairro, String cep, String clientName, String cityName) {
        this.id = id;
        this.logradouro = logradouro;
        this.number = number;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.clientName = clientName;
        this.cityName = cityName;
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}