package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.AddressDomain;

import java.util.Optional;

public interface GetAddressByIdGateway {

    Optional<AddressDomain> execute(Integer id);
}
