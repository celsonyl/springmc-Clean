package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.PaymentDomain;

import java.util.Optional;

public interface GetPaymentByOrderIdGateway {

    Optional<PaymentDomain> execute(Integer id);
}