package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.StateRequest;
import com.nyller.springmcclean.translator.StateMapperImpl;
import com.nyller.springmcclean.usecase.CreateStateUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/state")
public class StateController {

    @Autowired
    private CreateStateUsecase createStateUsecase;

    @PostMapping
    public ResponseEntity<StateRequest> createState(@RequestBody StateRequest stateRequest, UriComponentsBuilder uriComponentsBuilder) {
        var stateMapper = new StateMapperImpl();
        var state = createStateUsecase.execute(stateMapper.stateRequestToDomain(stateRequest));

        var uri = uriComponentsBuilder.path("/state/{id}").buildAndExpand(state.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}