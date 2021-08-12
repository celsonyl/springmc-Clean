package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.StateDomain;
import com.nyller.springmcclean.gateway.GetAllStatesGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllStatesUsecase {

    @Autowired
    private GetAllStatesGateway getAllStatesGateway;

    public List<StateDomain> execute() {
        return getAllStatesGateway.execute();
    }
}