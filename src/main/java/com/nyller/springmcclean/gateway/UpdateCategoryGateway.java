package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.CategoryDomain;

import java.util.Optional;

public interface UpdateCategoryGateway {
    Optional<CategoryDomain> updateCategory(Integer id, CategoryDomain categoryDomain);
}