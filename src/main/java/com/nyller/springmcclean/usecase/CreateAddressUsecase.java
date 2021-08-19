package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.AddressDomain;
import com.nyller.springmcclean.gateway.CreateAddressGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateAddressUsecase {

    @Autowired
    private CreateAddressGateway createAddressGateway;

    public AddressDomain execute(AddressDomain addressDomain) {
        return createAddressGateway.execute(addressDomain);
    }
}