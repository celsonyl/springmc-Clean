package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.PaymentResponse;
import com.nyller.springmcclean.translator.PaymentMapper;
import com.nyller.springmcclean.usecase.GetPaymentByOrderIdUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private GetPaymentByOrderIdUsecase getPaymentByOrderIdUsecase;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PaymentResponse> getPayment(@PathVariable Integer id) {
        var paymentMapper = new PaymentMapper();
        var payment = getPaymentByOrderIdUsecase.execute(id);

        return ResponseEntity.ok().body(paymentMapper.paymentDomainToResponse(payment));
    }
}