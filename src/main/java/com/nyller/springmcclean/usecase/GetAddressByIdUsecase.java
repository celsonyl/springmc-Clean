package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.AddressDomain;
import com.nyller.springmcclean.domain.exceptions.ObjectNotFoundException;
import com.nyller.springmcclean.gateway.GetAddressByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAddressByIdUsecase {

    @Autowired
    private GetAddressByIdGateway getAddressByIdGateway;

    public AddressDomain execute(Integer id) {
        return getAddressByIdGateway.execute(id)
                .orElseThrow(() -> new ObjectNotFoundException("Address not found!"));
    }
}