package com.nyller.springmcclean.gateway.h2database.model;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "address")
@Builder
public class AddressDatabase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String logradouro;
    private String number;
    private String complemento;
    private String bairro;
    private String cep;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientDatabase clientDatabase;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityDatabase cityDatabase;

    public AddressDatabase() {
    }
    
    public AddressDatabase(Integer id, String logradouro, String number, String complemento,
                           String bairro, String cep, ClientDatabase clientDatabase, CityDatabase cityDatabase) {
        this.id = id;
        this.logradouro = logradouro;
        this.number = number;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.clientDatabase = clientDatabase;
        this.cityDatabase = cityDatabase;
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

    public ClientDatabase getClientDatabase() {
        return clientDatabase;
    }

    public void setClientDatabase(ClientDatabase clientDatabase) {
        this.clientDatabase = clientDatabase;
    }

    public CityDatabase getCityDatabase() {
        return cityDatabase;
    }

    public void setCityDatabase(CityDatabase cityDatabase) {
        this.cityDatabase = cityDatabase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDatabase that = (AddressDatabase) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}