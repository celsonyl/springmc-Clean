package com.nyller.springmcclean.translator;

import com.nyller.springmcclean.controller.model.AddressResponseGetAll;
import com.nyller.springmcclean.controller.model.ClientResponseAddress;
import com.nyller.springmcclean.controller.model.OrderRequest;
import com.nyller.springmcclean.controller.model.OrderResponse;
import com.nyller.springmcclean.domain.AddressDomain;
import com.nyller.springmcclean.domain.CityDomain;
import com.nyller.springmcclean.domain.ClientDomain;
import com.nyller.springmcclean.domain.OrderDomain;
import com.nyller.springmcclean.gateway.h2database.model.AddressDatabase;
import com.nyller.springmcclean.gateway.h2database.model.ClientDatabase;
import com.nyller.springmcclean.gateway.h2database.model.OrderDatabase;

public class OrderMapper {

    public OrderDomain orderRequestToDomain(OrderRequest orderRequest) {
        var clientDomain = ClientDomain.builder()
                .id(orderRequest.getClientRequest().getId())
                .build();

        var addressDomain = AddressDomain.builder()
                .id(orderRequest.getAddressRequest().getId())
                .build();

        return OrderDomain.builder()
                .id(orderRequest.getId())
                .instant(orderRequest.getInstant())
                .clientDomain(clientDomain)
                .addressDomain(addressDomain)
                .build();
    }

    public OrderDomain orderDataseToDomain(OrderDatabase orderDatabase) {
        var clientDomain = ClientDomain.builder()
                .id(orderDatabase.getClientDatabase().getId())
                .build();

        var addressDomain = AddressDomain.builder()
                .id(orderDatabase.getAddressDatabase().getId())
                .build();

        return OrderDomain.builder()
                .id(orderDatabase.getId())
                .instant(orderDatabase.getInstant())
                .clientDomain(clientDomain)
                .addressDomain(addressDomain)
                .build();
    }

    public OrderDatabase orderDomainToDabatase(OrderDomain orderDomain) {
        var clientDatabase = ClientDatabase.builder()
                .id(orderDomain.getClientDomain().getId())
                .build();
        var addressDatabase = AddressDatabase.builder()
                .id(orderDomain.getAddressDomain().getId())
                .build();

        return OrderDatabase.builder()
                .id(orderDomain.getId())
                .instant(orderDomain.getInstant())
                .clientDatabase(clientDatabase)
                .addressDatabase(addressDatabase)
                .paymentDatabase(null)
                .build();
    }

    public OrderResponse orderDomainToResponse(OrderDomain orderDomain) {
        var address = AddressResponseGetAll.builder()
                .id(orderDomain.getAddressDomain().getId())
                .bairro(orderDomain.getAddressDomain().getBairro())
                .cep(orderDomain.getAddressDomain().getCep())
                .cityName(orderDomain.getAddressDomain().getCityDomain().getName())
                .complemento(orderDomain.getAddressDomain().getComplemento())
                .number(orderDomain.getAddressDomain().getNumber())
                .logradouro(orderDomain.getAddressDomain().getLogradouro())
                .build();

        var client = ClientResponseAddress.builder()
                .id(orderDomain.getClientDomain().getId())
                .cpf(orderDomain.getClientDomain().getCpf())
                .name(orderDomain.getClientDomain().getName())
                .email(orderDomain.getClientDomain().getEmail())
                .clientType(orderDomain.getClientDomain().getClientType())
                .phones(orderDomain.getClientDomain().getPhones())
                .build();

        return OrderResponse.builder()
                .id(orderDomain.getId())
                .instant(orderDomain.getInstant())
                .addressResponseGetAll(address)
                .clientResponseAddress(client)
                .build();
    }

    public OrderDomain orderDataseToDomainGetById(OrderDatabase orderDatabase) {
        var cityDomain = CityDomain.builder()
                .name(orderDatabase.getAddressDatabase().getCityDatabase().getName())
                .build();

        var clientDomain = ClientDomain.builder()
                .id(orderDatabase.getClientDatabase().getId())
                .name(orderDatabase.getClientDatabase().getName())
                .cpf(orderDatabase.getClientDatabase().getCpf())
                .email(orderDatabase.getClientDatabase().getEmail())
                .clientType(orderDatabase.getClientDatabase().getClientType())
                .phones(orderDatabase.getClientDatabase().getPhones())
                .build();

        var addressDomain = AddressDomain.builder()
                .id(orderDatabase.getAddressDatabase().getId())
                .number(orderDatabase.getAddressDatabase().getNumber())
                .cep(orderDatabase.getAddressDatabase().getCep())
                .complemento(orderDatabase.getAddressDatabase().getComplemento())
                .bairro(orderDatabase.getAddressDatabase().getBairro())
                .logradouro(orderDatabase.getAddressDatabase().getLogradouro())
                .cityDomain(cityDomain)
                .build();

        return OrderDomain.builder()
                .id(orderDatabase.getId())
                .instant(orderDatabase.getInstant())
                .clientDomain(clientDomain)
                .addressDomain(addressDomain)
                .build();
    }
}