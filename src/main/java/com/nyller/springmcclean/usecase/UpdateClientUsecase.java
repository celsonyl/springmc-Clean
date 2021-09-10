package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.ClientDomain;
import com.nyller.springmcclean.domain.exceptions.ObjectNotFoundException;
import com.nyller.springmcclean.gateway.UpdateClientGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateClientUsecase {

    @Autowired
    private UpdateClientGateway updateClientGateway;

    public void execute(ClientDomain clientDomain, Integer id) {
        updateClientGateway.execute(clientDomain, id)
                .orElseThrow(() -> new ObjectNotFoundException("Client not found!"));
    }
}