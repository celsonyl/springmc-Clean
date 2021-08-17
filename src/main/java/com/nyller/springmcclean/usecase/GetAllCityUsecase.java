package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.CityDomain;
import com.nyller.springmcclean.gateway.GetAllCityGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllCityUsecase {

    @Autowired
    private GetAllCityGateway getAllCityGateway;

    public List<CityDomain> execute() {
        return getAllCityGateway.execute();
    }
}