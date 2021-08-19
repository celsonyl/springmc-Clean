package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.AddressDomain;

public interface CreateAddressGateway {

    AddressDomain execute(AddressDomain addressDomain);
}