package com.nyller.springmcclean.translator;

import com.nyller.springmcclean.controller.model.CategoryRequest;
import com.nyller.springmcclean.controller.model.CategoryResponse;
import com.nyller.springmcclean.controller.model.ProductResponse;
import com.nyller.springmcclean.domain.CategoryDomain;
import com.nyller.springmcclean.domain.ProductDomain;
import com.nyller.springmcclean.gateway.h2database.model.CategoryDatabase;
import com.nyller.springmcclean.gateway.h2database.model.ProductDatabase;

import java.util.stream.Collectors;

public class CategoryMapper {

    public CategoryDatabase categoryDomainToDatabase(CategoryDomain categoryDomain) {
        if (categoryDomain.getProductDomainList() == null) {
            return CategoryDatabase.builder()
                    .id(categoryDomain.getId())
                    .name(categoryDomain.getName())
                    .build();
        }

        var list = categoryDomain.getProductDomainList().stream()
                .map(element -> ProductDatabase.builder()
                        .id(element.getId())
                        .name(element.getName())
                        .price(element.getPrice())
                        .build())
                .collect(Collectors.toList());

        return CategoryDatabase.builder()
                .id(categoryDomain.getId())
                .name(categoryDomain.getName())
                .products(list)
                .build();
    }

    public CategoryDomain categoryDatabaseToDomain(CategoryDatabase categoryDatabase) {
        if (categoryDatabase.getProducts() == null) {
            return CategoryDomain.builder()
                    .id(categoryDatabase.getId())
                    .name(categoryDatabase.getName())
                    .build();
        }

        var list = categoryDatabase.getProducts().stream()
                .map(element -> ProductDomain.builder()
                        .id(element.getId())
                        .name(element.getName())
                        .price(element.getPrice())
                        .build())
                .collect(Collectors.toList());

        return CategoryDomain.builder()
                .id(categoryDatabase.getId())
                .name(categoryDatabase.getName())
                .productDomainList(list)
                .build();
    }

    public CategoryDomain categoryRequestToDomain(CategoryRequest categoryRequest) {
        return CategoryDomain.builder()
                .id(categoryRequest.getId())
                .name(categoryRequest.getName())
                .build();
    }

    public CategoryResponse categoryDomainToResponse(CategoryDomain categoryDomain) {
        var list = categoryDomain.getProductDomainList().stream()
                .map(element -> ProductResponse.builder()
                        .id(element.getId())
                        .name(element.getName())
                        .price(element.getPrice())
                        .build())
                .collect(Collectors.toList());

        return CategoryResponse.builder()
                .id(categoryDomain.getId())
                .name(categoryDomain.getName())
                .productResponseList(list)
                .build();
    }
}