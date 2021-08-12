package com.nyller.springmcclean.translator;

import com.nyller.springmcclean.controller.model.StateRequest;
import com.nyller.springmcclean.domain.StateDomain;
import com.nyller.springmcclean.gateway.h2database.model.StateDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface StateMapper {

    StateDatabase stateDomainToDatabase(StateDomain stateDomain);

    StateDomain stateDataseToDomain(StateDatabase stateDatabase);

    StateDomain stateRequestToDomain(StateRequest stateRequest);
}