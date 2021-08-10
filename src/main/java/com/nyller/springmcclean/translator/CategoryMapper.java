package com.nyller.springmcclean.translator;

import com.nyller.springmcclean.controller.model.CategoryRequest;
import com.nyller.springmcclean.controller.model.CategoryResponse;
import com.nyller.springmcclean.domain.CategoryDomain;
import com.nyller.springmcclean.gateway.h2database.model.CategoryDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    CategoryDatabase categoryDomainToDatabase(CategoryDomain categoryDomain);

    CategoryDomain categoryDatabaseToDomain(CategoryDatabase categoryDatabase);

    CategoryDomain categoryRequestToDomain(CategoryRequest categoryRequest);

    CategoryResponse categoryDomainToResponse(CategoryDomain categoryDomain);
}
