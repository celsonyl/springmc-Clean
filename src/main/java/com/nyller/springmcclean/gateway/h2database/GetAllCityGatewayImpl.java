package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.CityDomain;
import com.nyller.springmcclean.gateway.GetAllCityGateway;
import com.nyller.springmcclean.gateway.h2database.repository.CityRepository;
import com.nyller.springmcclean.translator.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllCityGatewayImpl implements GetAllCityGateway {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityDomain> execute() {
        var cityMapper = new CityMapper();
        var cities = cityRepository.findAll();

        return cities.stream()
                .map(cityMapper::cityDatabaseToDomain)
                .collect(Collectors.toList());
    }
}