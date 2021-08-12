package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.StateDomain;

public interface CreateStateGateway {

    StateDomain execute(StateDomain stateDomain);
}