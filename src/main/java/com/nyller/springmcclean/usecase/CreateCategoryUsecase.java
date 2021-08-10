package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.CategoryDomain;
import com.nyller.springmcclean.gateway.CreateCategoryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryUsecase {

    @Autowired
    private CreateCategoryGateway createCategoryGateway;

    public CategoryDomain execute(CategoryDomain categoryDomain) {
        return createCategoryGateway.execute(categoryDomain);
    }
}
