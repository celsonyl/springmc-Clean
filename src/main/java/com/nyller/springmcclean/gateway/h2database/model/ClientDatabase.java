package com.nyller.springmcclean.gateway.h2database.model;

import com.nyller.springmcclean.domain.enums.ClientType;
import lombok.Builder;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.*;

@Entity(name = "client")
@Builder
public class ClientDatabase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(unique = true)
    @Email(message = "Invalid email")
    private String email;

    @Column(unique = true)
    @CPF(message = "Invalid CPF!")
    private String cpf;

    @Enumerated(EnumType.STRING)
    private ClientType clientType;

    @OneToMany(mappedBy = "clientDatabase")
    private List<AddressDatabase> addressDatabase = new ArrayList<>();

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ElementCollection
    @CollectionTable(name = "phones")
    private Set<String> phones = new HashSet<>();

    @OneToMany(mappedBy = "clientDatabase")
    private List<OrderDatabase> orderDatabaseList = new ArrayList<>();

    public ClientDatabase() {
    }

    public ClientDatabase(Integer id, String name, String email, String cpf, ClientType clientType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.clientType = clientType;
    }

    public ClientDatabase(Integer id, String name, String email, String cpf, ClientType clientType, List<AddressDatabase> addressDatabase,
                          Set<String> phones, List<OrderDatabase> orderDatabaseList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.clientType = clientType;
        this.addressDatabase = addressDatabase;
        this.phones = phones;
        this.orderDatabaseList = orderDatabaseList;
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

    public List<AddressDatabase> getAddressDatabase() {
        return addressDatabase;
    }

    public void setAddressDatabase(List<AddressDatabase> addressDatabase) {
        this.addressDatabase = addressDatabase;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public List<OrderDatabase> getOrderDatabaseList() {
        return orderDatabaseList;
    }

    public void setOrderDatabaseList(List<OrderDatabase> orderDatabaseList) {
        this.orderDatabaseList = orderDatabaseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDatabase that = (ClientDatabase) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}