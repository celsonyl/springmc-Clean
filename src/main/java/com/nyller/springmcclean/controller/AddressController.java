package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.AddressRequest;
import com.nyller.springmcclean.controller.model.AddressResponse;
import com.nyller.springmcclean.translator.AddressMapper;
import com.nyller.springmcclean.usecase.CreateAddressUsecase;
import com.nyller.springmcclean.usecase.GetAddressByIdUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private CreateAddressUsecase createAddressUsecase;
    @Autowired
    private GetAddressByIdUsecase getAddressByIdUsecase;

    @PostMapping
    public ResponseEntity<Void> createAddress(@Valid @RequestBody AddressRequest addressRequest, UriComponentsBuilder uriComponentsBuilder) {
        var addressMapper = new AddressMapper();
        var address = createAddressUsecase.execute(addressMapper.addressRequestToDomain(addressRequest));

        var uri = uriComponentsBuilder.path("/address/{id}").buildAndExpand(address.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable Integer id) {
        var addressMapper = new AddressMapper();
        var address = getAddressByIdUsecase.execute(id);

        return ResponseEntity.ok().body(addressMapper.addressDomainToResponse(address));
    }
}