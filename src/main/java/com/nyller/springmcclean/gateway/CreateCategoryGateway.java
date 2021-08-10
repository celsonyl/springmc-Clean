package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.CategoryDomain;

public interface CreateCategoryGateway {

    CategoryDomain execute(CategoryDomain categoryDomain);
}
