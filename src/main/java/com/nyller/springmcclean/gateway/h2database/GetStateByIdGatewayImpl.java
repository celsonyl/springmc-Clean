package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.StateDomain;
import com.nyller.springmcclean.gateway.GetStateByIdGateway;
import com.nyller.springmcclean.gateway.h2database.repository.StateRepository;
import com.nyller.springmcclean.translator.StateMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetStateByIdGatewayImpl implements GetStateByIdGateway {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public Optional<StateDomain> execute(Integer id) {
        var stateMapper = new StateMapperImpl();
        var state = stateRepository.findById(id);
        if (state.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(stateMapper.stateDataseToDomain(state.get()));
    }
}