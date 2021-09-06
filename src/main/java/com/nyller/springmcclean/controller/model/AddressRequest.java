package com.nyller.springmcclean.controller.model;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Builder
public class AddressRequest implements Serializable {

    private Integer id;
    @NotBlank(message = "Field logradouro doesn't null or blank!")
    private String logradouro;
    @NotBlank(message = "Field number doesn't null or blank!")
    private String number;
    private String complemento;
    @NotBlank(message = "Field bairro doesn't null or blank!")
    private String bairro;
    @NotBlank(message = "Field cep doesn't null or blank!")
    private String cep;

    @NotNull(message = "Field Client doesn't null!")
    private ClientRequest clientRequest;

    @NotNull(message = "Field City doesn't null!")
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