package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.ClientDomain;

import java.util.Optional;

public interface GetClientByIdGateway {

    Optional<ClientDomain> execute(Integer id);
}