package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.StateDomain;
import com.nyller.springmcclean.domain.exceptions.DataIntegrityException;
import com.nyller.springmcclean.gateway.CreateStateGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class CreateStateUsecase {

    @Autowired
    private CreateStateGateway createStateGateway;

    public StateDomain execute(StateDomain stateDomain) {
        try {
            return createStateGateway.execute(stateDomain);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Este Estado já existe!" + stateDomain.getName());
        }
    }
}