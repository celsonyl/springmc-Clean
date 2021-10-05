package com.nyller.springmcclean.gateway.mysql;

import com.nyller.springmcclean.domain.StateDomain;
import com.nyller.springmcclean.gateway.GetAllStatesGateway;
import com.nyller.springmcclean.gateway.mysql.repository.StateRepository;
import com.nyller.springmcclean.translator.StateMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllStatesGatewayImpl implements GetAllStatesGateway {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<StateDomain> execute() {
        var stateMapper = new StateMapperImpl();
        var states = stateRepository.findAll();

        return states.stream()
                .map(stateMapper::stateDataseToDomain)
                .collect(Collectors.toList());
    }
}