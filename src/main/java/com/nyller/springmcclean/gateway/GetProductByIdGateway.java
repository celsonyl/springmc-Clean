package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.ProductDomain;

import java.util.Optional;

public interface GetProductByIdGateway {

    Optional<ProductDomain> execute(Integer id);
}