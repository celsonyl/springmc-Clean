package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.ProductDomain;

public interface CreateProductGateway {

    ProductDomain execute(ProductDomain productDomain);
}