package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.ProductDomain;

import java.util.List;

public interface GetAllProductsGateway {

    List<ProductDomain> execute();
}