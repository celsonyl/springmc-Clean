package com.nyller.springmcclean.gateway;

import com.nyller.springmcclean.domain.CategoryDomain;

import java.util.List;

public interface GetAllCategoriesGateway {

    List<CategoryDomain> execute();
}
