package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.ClientDomain;

import java.util.List;

public interface GetAllClientsGateway {

    List<ClientDomain> execute();
}