package com.nyller.springmcclean.translator;

import com.nyller.springmcclean.controller.model.ClientResponseAddress;
import com.nyller.springmcclean.controller.model.OrderResponse;
import com.nyller.springmcclean.controller.model.PaymentResponse;
import com.nyller.springmcclean.controller.translator.ClientTranslator;
import com.nyller.springmcclean.domain.OrderDomain;
import com.nyller.springmcclean.domain.PaymentDomain;
import com.nyller.springmcclean.gateway.h2database.model.PaymentByCardDatabase;
import com.nyller.springmcclean.gateway.h2database.model.PaymentWithBankSlipDatabase;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class PaymentMapper {

    public PaymentDomain paymentDatabaseWithCardToDomain(PaymentByCardDatabase paymentByCardDatabase) {
        var addressMapper = new AddressMapper();
        var clientTranslator = new ClientTranslator();

        String number = Integer.toString(paymentByCardDatabase.getNumberOfInstallments());
        Set<String> paymentMethod = new HashSet<>();
        paymentMethod.add("Credit card");
        paymentMethod.add("Number of Installments: " + number);

        var order = OrderDomain.builder()
                .id(paymentByCardDatabase.getOrderDatabase().getId())
                .instant(paymentByCardDatabase.getOrderDatabase().getInstant())
                .addressDomain(addressMapper.addressDatabaseToDomain(paymentByCardDatabase.getOrderDatabase().getAddressDatabase()))
                .clientDomain(clientTranslator.clientDatabaseToDomain(paymentByCardDatabase.getOrderDatabase().getClientDatabase()))
                .build();

        return PaymentDomain.builder()
                .id(paymentByCardDatabase.getId())
                .paymentStatus(paymentByCardDatabase.getPaymentStatus())
                .orderId(order)
                .paymentMethod(paymentMethod)
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
                .paymentMethod(paymentDomain.getPaymentMethod())
                .build();
    }

    public PaymentDomain paymentDatabaseBankSlip(PaymentWithBankSlipDatabase paymentWithBankSlipDatabase) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        var addressMapper = new AddressMapper();
        var clientTranslator = new ClientTranslator();

        String paymentDate = dateFormat.format(paymentWithBankSlipDatabase.getPaymentDate());
        String expirationDate = dateFormat.format(paymentWithBankSlipDatabase.getExpirationDate());

        Set<String> paymentMethod = new HashSet<>();
        paymentMethod.add("Bank Slip");
        paymentMethod.add("Payment Date: " + paymentDate);
        paymentMethod.add("Expiration Date: " + expirationDate);

        OrderDomain orderDomain = OrderDomain.builder()
                .id(paymentWithBankSlipDatabase.getOrderDatabase().getId())
                .instant(paymentWithBankSlipDatabase.getOrderDatabase().getInstant())
                .addressDomain(addressMapper.addressDatabaseToDomain(paymentWithBankSlipDatabase.getOrderDatabase().getAddressDatabase()))
                .clientDomain(clientTranslator.clientDatabaseToDomain(paymentWithBankSlipDatabase.getOrderDatabase().getClientDatabase()))
                .build();

        return PaymentDomain.builder()
                .id(paymentWithBankSlipDatabase.getId())
                .paymentStatus(paymentWithBankSlipDatabase.getPaymentStatus())
                .orderId(orderDomain)
                .paymentMethod(paymentMethod)
                .build();
    }
}