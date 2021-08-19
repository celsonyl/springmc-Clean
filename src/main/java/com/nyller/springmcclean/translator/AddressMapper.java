package com.nyller.springmcclean.translator;

import com.nyller.springmcclean.controller.model.*;
import com.nyller.springmcclean.domain.AddressDomain;
import com.nyller.springmcclean.domain.CityDomain;
import com.nyller.springmcclean.domain.ClientDomain;
import com.nyller.springmcclean.domain.StateDomain;
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
                .name(addressDomain.getCityDomain().getName())
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
                .name(addressDatabase.getCityDatabase().getName())
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

    public AddressResponse addressDomainToResponse(AddressDomain addressDomain) {
        if (addressDomain == null) {
            return null;
        }
        var stateResponse = StateResponse.builder()
                .id(addressDomain.getCityDomain().getStateDomain().getId())
                .name(addressDomain.getCityDomain().getStateDomain().getName())
                .build();

        var cityResponse = CityResponse.builder()
                .id(addressDomain.getCityDomain().getId())
                .name(addressDomain.getCityDomain().getName())
                .stateResponse(stateResponse)
                .build();

        var clientResponse = ClientResponse.builder()
                .id(addressDomain.getClientDomain().getId())
                .email(addressDomain.getClientDomain().getEmail())
                .name(addressDomain.getClientDomain().getName())
                .phones(addressDomain.getClientDomain().getPhones())
                .clientType(addressDomain.getClientDomain().getClientType())
                .build();

        return AddressResponse.builder()
                .id(addressDomain.getId())
                .cep(addressDomain.getCep())
                .bairro(addressDomain.getBairro())
                .complemento(addressDomain.getComplemento())
                .logradouro(addressDomain.getLogradouro())
                .number(addressDomain.getNumber())
                .cityResponse(cityResponse)
                .clientResponse(clientResponse)
                .build();
    }

    public AddressDomain addressDatabaseToDomainGet(AddressDatabase addressDatabase) {
        if (addressDatabase == null) {
            return null;
        }

        var stateDomain = StateDomain.builder()
                .id(addressDatabase.getCityDatabase().getStateDatabase().getId())
                .name(addressDatabase.getCityDatabase().getStateDatabase().getName())
                .build();

        var cityDomain = CityDomain.builder()
                .id(addressDatabase.getCityDatabase().getId())
                .name(addressDatabase.getCityDatabase().getName())
                .stateDomain(stateDomain)
                .build();

        var clientDomain = ClientDomain.builder()
                .id(addressDatabase.getCityDatabase().getId())
                .name(addressDatabase.getClientDatabase().getName())
                .cpf(addressDatabase.getClientDatabase().getCpf())
                .email(addressDatabase.getClientDatabase().getEmail())
                .clientType(addressDatabase.getClientDatabase().getClientType())
                .phones(addressDatabase.getClientDatabase().getPhones())
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
}