package com.nyller.springmcclean.controller.translator;

import com.nyller.springmcclean.controller.model.ClientResponse;
import com.nyller.springmcclean.domain.ClientDomain;
import com.nyller.springmcclean.gateway.mysql.model.ClientDatabase;
import com.nyller.springmcclean.translator.AddressMapper;

import java.util.stream.Collectors;

public class ClientTranslator {

    public ClientDomain clientDatabaseToDomain(ClientDatabase clientDatabase) {
        var addressMapper = new AddressMapper();

        var listAddressDomain = clientDatabase.getAddressDatabase()
                .stream()
                .map(addressMapper::addressDatabaseToDomain)
                .collect(Collectors.toList());

        return ClientDomain.builder()
                .id(clientDatabase.getId())
                .name(clientDatabase.getName())
                .cpf(clientDatabase.getCpf())
                .email(clientDatabase.getEmail())
                .clientType(clientDatabase.getClientType())
                .phones(clientDatabase.getPhones())
                .addressDomains(listAddressDomain)
                .build();
    }

    public ClientResponse clientDomainToResponse(ClientDomain clientDomain) {
        var addressMapper = new AddressMapper();
        var listAddress = clientDomain.getAddressDomains()
                .stream()
                .map(addressMapper::addressDomainToResponseGetAll)
                .collect(Collectors.toList());

        return ClientResponse.builder()
                .id(clientDomain.getId())
                .name(clientDomain.getName())
                .email(clientDomain.getEmail())
                .cpf(clientDomain.getCpf())
                .clientType(clientDomain.getClientType())
                .phones(clientDomain.getPhones())
                .address(listAddress)
                .build();
    }
}