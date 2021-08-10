package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.CategoryDomain;

import java.util.Optional;

public interface GetCategoryByIdGateway {

    Optional<CategoryDomain> execute(Integer id);
}
