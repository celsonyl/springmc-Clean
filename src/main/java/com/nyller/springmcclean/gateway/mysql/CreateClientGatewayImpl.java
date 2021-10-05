package com.nyller.springmcclean.gateway.mysql;

import com.nyller.springmcclean.domain.ClientDomain;
import com.nyller.springmcclean.gateway.CreateClientGateway;
import com.nyller.springmcclean.gateway.mysql.repository.ClientRepository;
import com.nyller.springmcclean.translator.ClientMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateClientGatewayImpl implements CreateClientGateway {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDomain execute(ClientDomain clientDomain) {
        var clientMapper = new ClientMapperImpl();
        var client = clientRepository.save(clientMapper.clientDomainToDatabase(clientDomain));

        return clientMapper.clientDatabaseToDomain(client);
    }
}