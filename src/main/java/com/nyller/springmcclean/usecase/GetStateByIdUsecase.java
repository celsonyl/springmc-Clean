package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.StateDomain;
import com.nyller.springmcclean.domain.exceptions.ObjectNotFoundException;
import com.nyller.springmcclean.gateway.GetStateByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetStateByIdUsecase {

    @Autowired
    private GetStateByIdGateway getStateByIdGateway;

    public StateDomain execute(Integer id) {
        return getStateByIdGateway.execute(id)
                .orElseThrow(() -> new ObjectNotFoundException("State not found! " + id));
    }
}