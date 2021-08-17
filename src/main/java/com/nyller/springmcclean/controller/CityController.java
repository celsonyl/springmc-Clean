package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.CityRequest;
import com.nyller.springmcclean.controller.model.CityResponse;
import com.nyller.springmcclean.translator.CityMapper;
import com.nyller.springmcclean.usecase.CreateCityUsecase;
import com.nyller.springmcclean.usecase.GetAllCityUsecase;
import com.nyller.springmcclean.usecase.GetCityByIdUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CreateCityUsecase createCityUsecase;
    @Autowired
    private GetCityByIdUsecase getCityByIdUsecase;
    @Autowired
    private GetAllCityUsecase getAllCityUsecase;

    @PostMapping
    public ResponseEntity<Void> createCity(@Valid @RequestBody CityRequest cityRequest, UriComponentsBuilder uriComponentsBuilder) {
        var cityMapper = new CityMapper();
        var city = createCityUsecase.execute(cityMapper.cityRequestToDomain(cityRequest));

        var uri = uriComponentsBuilder.path("/city/{id}").buildAndExpand(city.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CityResponse> getCityById(@PathVariable Integer id) {
        var cityMapper = new CityMapper();
        var city = getCityByIdUsecase.execute(id);

        return ResponseEntity.ok().body(cityMapper.cityDomainToResponse(city));
    }

    @GetMapping()
    public ResponseEntity<List<CityResponse>> getAllCities() {
        var cityMapper = new CityMapper();
        var cities = getAllCityUsecase.execute();

        return ResponseEntity.ok().body(cities.stream().map(cityMapper::cityDomainToResponse)
                .collect(Collectors.toList()));
    }
}