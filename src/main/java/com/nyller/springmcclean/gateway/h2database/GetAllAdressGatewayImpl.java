package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.AddressDomain;
import com.nyller.springmcclean.gateway.GetAllAdressGateway;
import com.nyller.springmcclean.gateway.h2database.repository.AddressRepository;
import com.nyller.springmcclean.translator.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllAdressGatewayImpl implements GetAllAdressGateway {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<AddressDomain> execute() {
        var adressMapper = new AddressMapper();
        var address = addressRepository.findAll();

        return address.stream()
                .map(adressMapper::addressDatabaseToDomainGetAll)
                .collect(Collectors.toList());
    }
}