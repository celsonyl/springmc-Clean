package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.ClientDomain;
import com.nyller.springmcclean.gateway.GetAllClientsGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllClientsUsecase {

    @Autowired
    private GetAllClientsGateway getAllClientsGateway;

    public List<ClientDomain> execut() {
        return getAllClientsGateway.execute();
    }
}