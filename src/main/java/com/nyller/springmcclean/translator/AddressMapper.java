package com.nyller.springmcclean.translator;

import com.nyller.springmcclean.controller.model.AddressRequest;
import com.nyller.springmcclean.domain.AddressDomain;
import com.nyller.springmcclean.domain.CityDomain;
import com.nyller.springmcclean.domain.ClientDomain;
import com.nyller.springmcclean.gateway.h2database.model.AddressDatabase;
import com.nyller.springmcclean.gateway.h2database.model.CityDatabase;
import com.nyller.springmcclean.gateway.h2database.model.ClientDatabase;

public class AddressMapper {

    public AddressDatabase addressDomainToDatabase(AddressDomain addressDomain) {
        if (addressDomain == null) {
            return null;
        }

        var cityDatabase = CityDatabase.builder()
                .id(addressDomain.getCityDomain().getId())
                .build();

        var clientDatabase = ClientDatabase.builder()
                .id(addressDomain.getClientDomain().getId())
                .build();

        return AddressDatabase.builder()
                .id(addressDomain.getId())
                .logradouro(addressDomain.getLogradouro())
                .number(addressDomain.getNumber())
                .bairro(addressDomain.getBairro())
                .complemento(addressDomain.getComplemento())
                .cep(addressDomain.getCep())
                .clientDatabase(clientDatabase)
                .cityDatabase(cityDatabase)
                .build();
    }

    public AddressDomain addressDatabaseToDomain(AddressDatabase addressDatabase) {
        if (addressDatabase == null) {
            return null;
        }
        var cityDomain = CityDomain.builder()
                .id(addressDatabase.getCityDatabase().getId())
                .build();

        var clientDomain = ClientDomain.builder()
                .id(addressDatabase.getCityDatabase().getId())
                .build();

        return AddressDomain.builder()
                .id(addressDatabase.getId())
                .number(addressDatabase.getNumber())
                .bairro(addressDatabase.getBairro())
                .cep(addressDatabase.getCep())
                .complemento(addressDatabase.getComplemento())
                .logradouro(addressDatabase.getLogradouro())
                .clientDomain(clientDomain)
                .cityDomain(cityDomain)
                .build();
    }

    public AddressDomain addressRequestToDomain(AddressRequest addressRequest) {
        if (addressRequest == null) {
            return null;
        }

        var cityDomain = CityDomain.builder()
                .id(addressRequest.getCityRequest().getId())
                .build();

        var clientDomain = ClientDomain.builder()
                .id(addressRequest.getClientRequest().getId())
                .build();

        return AddressDomain.builder()
                .id(addressRequest.getId())
                .number(addressRequest.getNumber())
                .bairro(addressRequest.getBairro())
                .cep(addressRequest.getCep())
                .complemento(addressRequest.getComplemento())
                .logradouro(addressRequest.getLogradouro())
                .clientDomain(clientDomain)
                .cityDomain(cityDomain)
                .build();
    }
}