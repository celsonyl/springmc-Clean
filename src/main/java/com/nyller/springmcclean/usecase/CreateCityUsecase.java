package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.CityDomain;
import com.nyller.springmcclean.gateway.CreateCityGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCityUsecase {

    @Autowired
    private CreateCityGateway createCityGateway;

    public CityDomain execute(CityDomain cityDomain) {
        return createCityGateway.execute(cityDomain);
    }
}