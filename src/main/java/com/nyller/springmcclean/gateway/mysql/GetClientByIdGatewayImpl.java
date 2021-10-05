package com.nyller.springmcclean.gateway.mysql;

import com.nyller.springmcclean.controller.translator.ClientTranslator;
import com.nyller.springmcclean.domain.ClientDomain;
import com.nyller.springmcclean.gateway.GetClientByIdGateway;
import com.nyller.springmcclean.gateway.mysql.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetClientByIdGatewayImpl implements GetClientByIdGateway {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Optional<ClientDomain> execute(Integer id) {
        var clientTranslator = new ClientTranslator();
        var client = clientRepository.findById(id);
        if (client.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(clientTranslator.clientDatabaseToDomain(client.get()));
    }
}