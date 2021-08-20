package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.ClientDomain;
import com.nyller.springmcclean.domain.exceptions.DataIntgrityViolation;
import com.nyller.springmcclean.gateway.CreateClientGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class CreateClientUsecase {

    @Autowired
    private CreateClientGateway createClientGateway;

    public ClientDomain execute(ClientDomain clientDomain) {
        try {
            return createClientGateway.execute(clientDomain);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntgrityViolation("Esse email já existe!");
        }
    }
}