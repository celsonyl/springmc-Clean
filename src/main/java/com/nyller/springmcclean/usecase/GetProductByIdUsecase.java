package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.ProductDomain;
import com.nyller.springmcclean.domain.exceptions.ObjectNotFoundException;
import com.nyller.springmcclean.gateway.GetProductByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetProductByIdUsecase {

    @Autowired
    private GetProductByIdGateway getProductByIdGateway;

    public ProductDomain execute(Integer id) {
        return getProductByIdGateway.execute(id)
                .orElseThrow(() -> new ObjectNotFoundException("Produto não existe! " + id));
    }
}