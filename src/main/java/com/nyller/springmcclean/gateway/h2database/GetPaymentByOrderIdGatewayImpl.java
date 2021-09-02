package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.PaymentDomain;
import com.nyller.springmcclean.gateway.GetPaymentByOrderIdGateway;
import com.nyller.springmcclean.gateway.h2database.repository.PaymentRepository;
import com.nyller.springmcclean.translator.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetPaymentByOrderIdGatewayImpl implements GetPaymentByOrderIdGateway {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Optional<PaymentDomain> execute(Integer id) {
        var paymentMapper = new PaymentMapper();
        var payment = paymentRepository.findById(id);

        if (payment.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(paymentMapper.paymentDatabaseToDomain(payment.get()));
    }
}