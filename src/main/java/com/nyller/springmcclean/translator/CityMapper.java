package com.nyller.springmcclean.translator;

import com.nyller.springmcclean.controller.model.CityRequest;
import com.nyller.springmcclean.controller.model.CityResponse;
import com.nyller.springmcclean.controller.model.StateResponse;
import com.nyller.springmcclean.domain.CityDomain;
import com.nyller.springmcclean.domain.StateDomain;
import com.nyller.springmcclean.gateway.mysql.model.CityDatabase;
import com.nyller.springmcclean.gateway.mysql.model.StateDatabase;

public class CityMapper {

    public CityDomain cityDatabaseToDomain(CityDatabase cityDatabase) {
        if (cityDatabase == null) {
            return null;
        }
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
        if (cityDomain == null) {
            return null;
        }
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
        if (cityRequest == null) {
            return null;
        }
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

    public CityResponse cityDomainToResponse(CityDomain cityDomain) {
        if (cityDomain == null) {
            return null;
        }
        var stateResponse = StateResponse.builder()
                .id(cityDomain.getStateDomain().getId())
                .name(cityDomain.getStateDomain().getName())
                .build();

        return CityResponse.builder()
                .id(cityDomain.getId())
                .name(cityDomain.getName())
                .stateResponse(stateResponse)
                .build();
    }
}