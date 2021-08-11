package com.nyller.springmcclean.translator;

import com.nyller.springmcclean.controller.model.ProductRequest;
import com.nyller.springmcclean.controller.model.ProductResponse;
import com.nyller.springmcclean.domain.ProductDomain;
import com.nyller.springmcclean.gateway.h2database.model.ProductDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    ProductDatabase productDomainToDatabase(ProductDomain productDomain);

    ProductDomain productDatabaseToDomain(ProductDatabase productDatabase);

    ProductDomain productRequestToDomain(ProductRequest productRequest);

    ProductResponse productDomainToResponse(ProductDomain productDomain);
}