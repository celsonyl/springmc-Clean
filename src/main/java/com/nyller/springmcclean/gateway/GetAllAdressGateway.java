package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.AddressDomain;

import java.util.List;

public interface GetAllAdressGateway {

    List<AddressDomain> execute();
}