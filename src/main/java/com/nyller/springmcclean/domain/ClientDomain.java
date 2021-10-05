package com.nyller.springmcclean.domain;

import com.nyller.springmcclean.domain.enums.ClientType;
import lombok.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
public class ClientDomain implements Serializable {

    private Integer id;
    private String name;
    private String email;
    private ClientType clientType;
    private String cpf;
    private Set<String> phones = new HashSet<>();
    private List<AddressDomain> addressDomains = new ArrayList<>();

    public ClientDomain() {
    }

    public ClientDomain(Integer id, String name, String email, ClientType clientType, String cpf, Set<String> phones, List<AddressDomain> addressDomains) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.clientType = clientType;
        this.cpf = cpf;
        this.phones = phones;
        this.addressDomains = addressDomains;
    }

    public ClientDomain(Integer id, String name, String email, ClientType clientType, String cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.clientType = clientType;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public List<AddressDomain> getAddressDomains() {
        return addressDomains;
    }

    public void setAddressDomains(List<AddressDomain> addressDomains) {
        this.addressDomains = addressDomains;
    }
}