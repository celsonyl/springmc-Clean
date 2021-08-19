package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.AddressDomain;
import com.nyller.springmcclean.gateway.CreateAddressGateway;
import com.nyller.springmcclean.gateway.h2database.repository.AddressRepository;
import com.nyller.springmcclean.translator.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateAddressGatewayImpl implements CreateAddressGateway {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressDomain execute(AddressDomain addressDomain) {
        var addressMapper = new AddressMapper();
        var address = addressRepository.save(addressMapper.addressDomainToDatabase(addressDomain));

        return addressMapper.addressDatabaseToDomain(address);
    }
}