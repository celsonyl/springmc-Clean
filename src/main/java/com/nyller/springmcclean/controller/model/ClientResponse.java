package com.nyller.springmcclean.controller.model;

import com.nyller.springmcclean.domain.enums.ClientType;
import lombok.Builder;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Builder
public class ClientResponse implements Serializable {

    private Integer id;
    private String name;
    private String email;
    private ClientType clientType;
    private Set<String> phones = new HashSet<>();

    public ClientResponse() {
    }

    public ClientResponse(Integer id, String name, String email, ClientType clientType, Set<String> phones) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.clientType = clientType;
        this.phones = phones;
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
}