package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.AddressRequest;
import com.nyller.springmcclean.translator.AddressMapper;
import com.nyller.springmcclean.usecase.CreateAddressUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private CreateAddressUsecase createAddressUsecase;

    @PostMapping
    public ResponseEntity<Void> createAddress(@Valid @RequestBody AddressRequest addressRequest, UriComponentsBuilder uriComponentsBuilder) {
        var addressMapper = new AddressMapper();
        var address = createAddressUsecase.execute(addressMapper.addressRequestToDomain(addressRequest));

        var uri = uriComponentsBuilder.path("/address/{id}").buildAndExpand(address.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}