package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.StateDomain;

import java.util.Optional;

public interface GetStateByIdGateway {

    Optional<StateDomain> execute(Integer id);
}