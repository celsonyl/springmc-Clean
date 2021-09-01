package com.nyller.springmcclean.translator;

import com.nyller.springmcclean.controller.model.OrderRequest;
import com.nyller.springmcclean.domain.AddressDomain;
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
}