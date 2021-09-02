package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.PaymentDomain;
import com.nyller.springmcclean.domain.exceptions.ObjectNotFoundException;
import com.nyller.springmcclean.gateway.GetPaymentByOrderIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPaymentByOrderIdUsecase {

    @Autowired
    private GetPaymentByOrderIdGateway getPaymentByOrderIdGateway;

    public PaymentDomain execute(Integer id) {
        return getPaymentByOrderIdGateway.execute(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }
}