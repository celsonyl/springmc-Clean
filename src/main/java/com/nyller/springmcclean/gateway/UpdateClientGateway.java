package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.ClientDomain;

import java.util.Optional;

public interface UpdateClientGateway {

    Optional<ClientDomain> execute(ClientDomain clientDomain, Integer id);
}