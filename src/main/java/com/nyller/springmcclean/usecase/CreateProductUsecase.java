package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.ProductDomain;
import com.nyller.springmcclean.gateway.CreateProductGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProductUsecase {

    @Autowired
    private CreateProductGateway createProductGateway;

    public ProductDomain execute(ProductDomain productDomain) {
        return createProductGateway.execute(productDomain);
    }
}