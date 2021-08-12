package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.StateDomain;
import com.nyller.springmcclean.gateway.CreateStateGateway;
import com.nyller.springmcclean.gateway.h2database.repository.StateRepository;
import com.nyller.springmcclean.translator.StateMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateStateGatewayImpl implements CreateStateGateway {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public StateDomain execute(StateDomain stateDomain) {
        var stateMapper = new StateMapperImpl();
        var state = stateRepository.save(stateMapper.stateDomainToDatabase(stateDomain));

        return stateMapper.stateDataseToDomain(state);
    }
}