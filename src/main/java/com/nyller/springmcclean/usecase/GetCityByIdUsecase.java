package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.CityDomain;
import com.nyller.springmcclean.domain.exceptions.ObjectNotFoundException;
import com.nyller.springmcclean.gateway.GetCityByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetCityByIdUsecase {

    @Autowired
    private GetCityByIdGateway cityByIdGateway;

    public CityDomain execute(Integer id) {
        return cityByIdGateway.execute(id)
                .orElseThrow(() -> new ObjectNotFoundException("City not found!"));
    }
}