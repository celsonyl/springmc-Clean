package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.ClientDomain;
import com.nyller.springmcclean.gateway.UpdateClientGateway;
import com.nyller.springmcclean.gateway.h2database.model.ClientDatabase;
import com.nyller.springmcclean.gateway.h2database.repository.ClientRepository;
import com.nyller.springmcclean.translator.ClientMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateClientGatewayImpl implements UpdateClientGateway {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Optional<ClientDomain> execute(ClientDomain clientDomain, Integer id) {
        var clientMapper = new ClientMapperImpl();
        var client = clientRepository.findById(id);
        if (client.isEmpty()) {
            return Optional.empty();
        }

        updateClient(client.get(), clientDomain);
        var clientUpdate = clientRepository.save(client.get());

        return Optional.of(clientMapper.clientDatabaseToDomain(clientUpdate));
    }

    private void updateClient(ClientDatabase client, ClientDomain clientDomain) {
        if (clientDomain.getName() != null)
            client.setName(clientDomain.getName());
        if (clientDomain.getEmail() != null)
            client.setEmail(clientDomain.getEmail());
        if (clientDomain.getClientType() != null)
            client.setClientType(clientDomain.getClientType());
        if (clientDomain.getPhones() != null)
            client.setPhones(clientDomain.getPhones());
    }
}