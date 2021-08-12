package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.StateDomain;

import java.util.List;

public interface GetAllStatesGateway {

    List<StateDomain> execute();
}