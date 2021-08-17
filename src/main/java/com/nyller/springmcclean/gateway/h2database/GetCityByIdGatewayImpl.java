package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.CityDomain;
import com.nyller.springmcclean.gateway.GetCityByIdGateway;
import com.nyller.springmcclean.gateway.h2database.repository.CityRepository;
import com.nyller.springmcclean.translator.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetCityByIdGatewayImpl implements GetCityByIdGateway {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Optional<CityDomain> execute(Integer id) {
        var cityMapper = new CityMapper();
        var city = cityRepository.findById(id);

        if (city.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(cityMapper.cityDatabaseToDomain(city.get()));
    }
}