package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.CityDomain;
import com.nyller.springmcclean.gateway.CreateCityGateway;
import com.nyller.springmcclean.gateway.h2database.repository.CityRepository;
import com.nyller.springmcclean.translator.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCityGatewayImpl implements CreateCityGateway {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public CityDomain execute(CityDomain cityDomain) {
        var cityMapper = new CityMapper();
        var city = cityRepository.save(cityMapper.cityDomainToDatabase(cityDomain));

        return cityMapper.cityDatabaseToDomain(city);
    }
}