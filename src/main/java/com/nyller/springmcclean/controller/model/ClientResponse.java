package com.nyller.springmcclean.controller.model;

import com.nyller.springmcclean.domain.enums.ClientType;
import lombok.Builder;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
public class ClientResponse implements Serializable {

    private Integer id;
    private String name;
    private String email;
    private String cpf;
    private ClientType clientType;
    private Set<String> phones = new HashSet<>();
    private List<AddressResponseGetAll> address;

    public ClientResponse() {
    }

    public ClientResponse(Integer id, String name, String email, String cpf, ClientType clientType, Set<String> phones, List<AddressResponseGetAll> address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.clientType = clientType;
        this.phones = phones;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public List<AddressResponseGetAll> getAddress() {
        return address;
    }

    public void setAddress(List<AddressResponseGetAll> address) {
        this.address = address;
    }
}