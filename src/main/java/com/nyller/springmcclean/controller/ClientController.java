package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.ClientRequest;
import com.nyller.springmcclean.translator.ClientMapperImpl;
import com.nyller.springmcclean.usecase.CreateClientUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "client")
public class ClientController {

    @Autowired
    private CreateClientUsecase createClientUsecase;

    @PostMapping
    public ResponseEntity<Void> createClient(@Valid @RequestBody ClientRequest clientRequest, UriComponentsBuilder uriComponentsBuilder) {
        var clientMapper = new ClientMapperImpl();
        var client = createClientUsecase.execute(clientMapper.clientRequestToDomain(clientRequest));

        var uri = uriComponentsBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}