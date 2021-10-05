package com.nyller.springmcclean.gateway.mysql;

import com.nyller.springmcclean.domain.AddressDomain;
import com.nyller.springmcclean.gateway.GetAddressByIdGateway;
import com.nyller.springmcclean.gateway.mysql.repository.AddressRepository;
import com.nyller.springmcclean.translator.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetAddressByIdGatewayImpl implements GetAddressByIdGateway {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Optional<AddressDomain> execute(Integer id) {
        var addressMapper = new AddressMapper();
        var address = addressRepository.findById(id);
        if (address.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(addressMapper.addressDatabaseToDomainGetById(address.get()));
    }
}