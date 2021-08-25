package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.ClientRequest;
import com.nyller.springmcclean.controller.model.ClientResponse;
import com.nyller.springmcclean.translator.ClientMapperImpl;
import com.nyller.springmcclean.usecase.CreateClientUsecase;
import com.nyller.springmcclean.usecase.GetAllClientsUsecase;
import com.nyller.springmcclean.usecase.GetClientByIdUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "client")
public class ClientController {

    @Autowired
    private CreateClientUsecase createClientUsecase;
    @Autowired
    private GetClientByIdUsecase getClientByIdUsecase;
    @Autowired
    private GetAllClientsUsecase getAllClientsUsecase;

    @PostMapping
    public ResponseEntity<Void> createClient(@Valid @RequestBody ClientRequest clientRequest, UriComponentsBuilder uriComponentsBuilder) {
        var clientMapper = new ClientMapperImpl();
        var client = createClientUsecase.execute(clientMapper.clientRequestToDomain(clientRequest));

        var uri = uriComponentsBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientResponse> getClientById(@PathVariable Integer id) {
        var clientMapper = new ClientMapperImpl();
        var client = getClientByIdUsecase.execute(id);

        return ResponseEntity.ok().body(clientMapper.clientDomainToResponse(client));
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAllClients() {
        var clientMapper = new ClientMapperImpl();
        var client = getAllClientsUsecase.execut();

        return ResponseEntity.ok().body(client.stream()
                .map(clientMapper::clientDomainToResponse)
                .collect(Collectors.toList()));
    }
}