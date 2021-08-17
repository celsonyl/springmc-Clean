package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.CityRequest;
import com.nyller.springmcclean.translator.CityMapper;
import com.nyller.springmcclean.usecase.CreateCityUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CreateCityUsecase createCityUsecase;

    @PostMapping
    public ResponseEntity<Void> createCity(@Valid @RequestBody CityRequest cityRequest, UriComponentsBuilder uriComponentsBuilder) {
        var cityMapper = new CityMapper();
        var city = createCityUsecase.execute(cityMapper.cityRequestToDomain(cityRequest));

        var uri = uriComponentsBuilder.path("/city/{id}").buildAndExpand(city.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}