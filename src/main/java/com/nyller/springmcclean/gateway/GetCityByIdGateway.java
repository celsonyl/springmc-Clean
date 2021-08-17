package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.CityDomain;

import java.util.Optional;

public interface GetCityByIdGateway {

    Optional<CityDomain> execute(Integer id);
}