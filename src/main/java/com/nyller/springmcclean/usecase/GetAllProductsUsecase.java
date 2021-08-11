package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.ProductDomain;
import com.nyller.springmcclean.gateway.GetAllProductsGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllProductsUsecase {

    @Autowired
    private GetAllProductsGateway getAllProductsGateway;

    public List<ProductDomain> execute() {
        return getAllProductsGateway.execute();
    }
}