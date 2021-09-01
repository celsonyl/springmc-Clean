package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.CityDomain;
import com.nyller.springmcclean.domain.exceptions.DataIntgrityViolation;
import com.nyller.springmcclean.gateway.CreateCityGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class CreateCityUsecase {

    @Autowired
    private CreateCityGateway createCityGateway;

    public CityDomain execute(CityDomain cityDomain) {
        try {
            return createCityGateway.execute(cityDomain);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntgrityViolation("Cidade já existe!" + cityDomain.getName());
        }
    }
}