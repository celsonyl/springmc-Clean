package com.nyller.springmcclean.gateway.mysql;

import com.nyller.springmcclean.controller.translator.ClientTranslator;
import com.nyller.springmcclean.domain.ClientDomain;
import com.nyller.springmcclean.gateway.GetAllClientsGateway;
import com.nyller.springmcclean.gateway.mysql.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllClientsGatewayImpl implements GetAllClientsGateway {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDomain> execute() {
        var clientTranslator = new ClientTranslator();
        var clients = clientRepository.findAll();

        return clients.stream()
                .map(clientTranslator::clientDatabaseToDomain)
                .collect(Collectors.toList());
    }
}