package com.nyller.springmcclean.gateway.mysql;

import com.nyller.springmcclean.domain.PaymentDomain;
import com.nyller.springmcclean.gateway.GetPaymentByOrderIdGateway;
import com.nyller.springmcclean.gateway.mysql.model.PaymentByCardDatabase;
import com.nyller.springmcclean.gateway.mysql.model.PaymentDatabase;
import com.nyller.springmcclean.gateway.mysql.model.PaymentWithBankSlipDatabase;
import com.nyller.springmcclean.gateway.mysql.repository.PaymentRepository;
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
        PaymentDatabase paymentCard = new PaymentByCardDatabase();

        var paymentMapper = new PaymentMapper();
        var payment = paymentRepository.findById(id);

        if (payment.isEmpty()) {

            return Optional.empty();
        } else if (payment.get().getClass().equals(paymentCard.getClass())) {

            return Optional.of(paymentMapper.paymentDatabaseWithCardToDomain((PaymentByCardDatabase) payment.get()));
        } else {

            return Optional.of(paymentMapper.paymentDatabaseBankSlip((PaymentWithBankSlipDatabase) payment.get()));
        }
    }
}