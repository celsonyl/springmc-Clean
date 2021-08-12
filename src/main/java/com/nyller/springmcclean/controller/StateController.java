package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.StateRequest;
import com.nyller.springmcclean.controller.model.StateResponse;
import com.nyller.springmcclean.translator.StateMapperImpl;
import com.nyller.springmcclean.usecase.CreateStateUsecase;
import com.nyller.springmcclean.usecase.GetAllStatesUsecase;
import com.nyller.springmcclean.usecase.GetStateByIdUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/state")
public class StateController {

    @Autowired
    private CreateStateUsecase createStateUsecase;

    @Autowired
    private GetStateByIdUsecase getStateByIdUsecase;

    @Autowired
    private GetAllStatesUsecase getAllStatesUsecase;

    @PostMapping
    public ResponseEntity<Void> createState(@Valid @RequestBody StateRequest stateRequest, UriComponentsBuilder uriComponentsBuilder) {
        var stateMapper = new StateMapperImpl();
        var state = createStateUsecase.execute(stateMapper.stateRequestToDomain(stateRequest));

        var uri = uriComponentsBuilder.path("/state/{id}").buildAndExpand(state.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StateResponse> getStateById(@PathVariable Integer id) {
        var stateMapper = new StateMapperImpl();
        var state = getStateByIdUsecase.execute(id);

        return ResponseEntity.ok().body(stateMapper.stateDomainToResponse(state));
    }

    @GetMapping
    public ResponseEntity<List<StateResponse>> getAllStates() {
        var stateMapper = new StateMapperImpl();
        var state = getAllStatesUsecase.execute();

        return ResponseEntity.ok().body(state.stream()
                .map(stateMapper::stateDomainToResponse)
                .collect(Collectors.toList()));
    }
}