package com.nyller.springmcclean.domain;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class AddressDomain implements Serializable {

    private Integer id;
    private String logradouro;
    private String number;
    private String complemento;
    private String bairro;
    private String cep;

    private ClientDomain clientDomain;

    private CityDomain cityDomain;

    public AddressDomain() {
    }

    public AddressDomain(Integer id, String logradouro, String number,
                         String complemento, String bairro, String cep, ClientDomain clientDomain, CityDomain cityDomain) {
        this.id = id;
        this.logradouro = logradouro;
        this.number = number;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.clientDomain = clientDomain;
        this.cityDomain = cityDomain;
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

    public ClientDomain getClientDomain() {
        return clientDomain;
    }

    public void setClientDomain(ClientDomain clientDomain) {
        this.clientDomain = clientDomain;
    }

    public CityDomain getCityDomain() {
        return cityDomain;
    }

    public void setCityDomain(CityDomain cityDomain) {
        this.cityDomain = cityDomain;
    }
}