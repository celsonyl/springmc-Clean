package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.AddressDomain;
import com.nyller.springmcclean.gateway.GetAllAdressGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllAdressUsecase {

    @Autowired
    private GetAllAdressGateway getAllAdressGateway;

    public List<AddressDomain> execute() {
        return getAllAdressGateway.execute();
    }
}