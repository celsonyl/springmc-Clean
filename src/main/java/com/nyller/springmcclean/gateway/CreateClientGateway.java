package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.ClientDomain;

public interface CreateClientGateway {

    ClientDomain execute(ClientDomain clientDomain);
}