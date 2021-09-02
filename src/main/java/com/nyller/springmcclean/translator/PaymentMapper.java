package com.nyller.springmcclean.translator;

import com.nyller.springmcclean.controller.model.ClientResponseAddress;
import com.nyller.springmcclean.controller.model.OrderResponse;
import com.nyller.springmcclean.controller.model.PaymentResponse;
import com.nyller.springmcclean.controller.translator.ClientTranslator;
import com.nyller.springmcclean.domain.OrderDomain;
import com.nyller.springmcclean.domain.PaymentDomain;
import com.nyller.springmcclean.gateway.h2database.model.PaymentDatabase;

public class PaymentMapper {

    public PaymentDomain paymentDatabaseToDomain(PaymentDatabase paymentDatabase) {
        var addressMapper = new AddressMapper();
        var clientTranslator = new ClientTranslator();

        var order = OrderDomain.builder()
                .id(paymentDatabase.getOrderDatabase().getId())
                .instant(paymentDatabase.getOrderDatabase().getInstant())
                .addressDomain(addressMapper.addressDatabaseToDomain(paymentDatabase.getOrderDatabase().getAddressDatabase()))
                .clientDomain(clientTranslator.clientDatabaseToDomain(paymentDatabase.getOrderDatabase().getClientDatabase()))
                .build();

        return PaymentDomain.builder()
                .id(paymentDatabase.getId())
                .paymentStatus(paymentDatabase.getPaymentStatus())
                .orderId(order)
                .build();
    }

    public PaymentResponse paymentDomainToResponse(PaymentDomain paymentDomain) {
        var addressMapper = new AddressMapper();

        var client = ClientResponseAddress.builder()
                .id(paymentDomain.getOrderId().getClientDomain().getId())
                .name(paymentDomain.getOrderId().getClientDomain().getName())
                .cpf(paymentDomain.getOrderId().getClientDomain().getCpf())
                .email(paymentDomain.getOrderId().getClientDomain().getEmail())
                .phones(paymentDomain.getOrderId().getClientDomain().getPhones())
                .clientType(paymentDomain.getOrderId().getClientDomain().getClientType())
                .build();

        var order = OrderResponse.builder()
                .id(paymentDomain.getOrderId().getId())
                .instant(paymentDomain.getOrderId().getInstant())
                .addressResponseGetAll(addressMapper.addressDomainToResponseGetAll(paymentDomain.getOrderId().getAddressDomain()))
                .clientResponseAddress(client)
                .build();

        return PaymentResponse.builder()
                .id(paymentDomain.getId())
                .paymentStatus(paymentDomain.getPaymentStatus())
                .orderResponse(order)
                .build();
    }
}