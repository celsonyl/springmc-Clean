package com.nyller.springmcclean.translator;

import com.nyller.springmcclean.controller.model.CityRequest;
import com.nyller.springmcclean.domain.CityDomain;
import com.nyller.springmcclean.domain.StateDomain;
import com.nyller.springmcclean.gateway.h2database.model.CityDatabase;
import com.nyller.springmcclean.gateway.h2database.model.StateDatabase;

public class CityMapper {

    public CityDomain cityDatabaseToDomain(CityDatabase cityDatabase) {
        var stateDomain = StateDomain.builder()
                .id(cityDatabase.getStateDatabase().getId())
                .name(cityDatabase.getStateDatabase().getName())
                .build();

        return CityDomain.builder()
                .id(cityDatabase.getId())
                .name(cityDatabase.getName())
                .stateDomain(stateDomain)
                .build();
    }

    public CityDatabase cityDomainToDatabase(CityDomain cityDomain) {
        var stateDatabase = StateDatabase.builder()
                .id(cityDomain.getStateDomain().getId())
                .name(cityDomain.getStateDomain().getName())
                .build();

        return CityDatabase.builder()
                .id(cityDomain.getId())
                .name(cityDomain.getName())
                .stateDatabase(stateDatabase)
                .build();
    }

    public CityDomain cityRequestToDomain(CityRequest cityRequest) {
        var stateDomain = StateDomain.builder()
                .id(cityRequest.getStateRequest().getId())
                .name(cityRequest.getName())
                .build();

        return CityDomain.builder()
                .id(cityRequest.getId())
                .name(cityRequest.getName())
                .stateDomain(stateDomain)
                .build();
    }
}