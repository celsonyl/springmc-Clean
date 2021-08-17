package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.CityDomain;

public interface CreateCityGateway {

    CityDomain execute(CityDomain cityDomain);
}