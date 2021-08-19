package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.ClientDomain;
import com.nyller.springmcclean.domain.exceptions.ObjectNotFoundException;
import com.nyller.springmcclean.gateway.GetClientByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetClientByIdUsecase {

    @Autowired
    private GetClientByIdGateway getClientByIdGateway;

    public ClientDomain execute(Integer id) {
        return getClientByIdGateway.execute(id)
                .orElseThrow(() -> new ObjectNotFoundException("Client not found! ID:" + id));
    }
}