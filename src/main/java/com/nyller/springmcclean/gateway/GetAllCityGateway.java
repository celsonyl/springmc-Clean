package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.CityDomain;

import java.util.List;

public interface GetAllCityGateway {

    List<CityDomain> execute();
}