package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.CategoryDomain;
import com.nyller.springmcclean.domain.exceptions.ObjectNotFoundException;
import com.nyller.springmcclean.gateway.UpdateCategoryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCategoryUsecase {

    @Autowired
    public UpdateCategoryGateway categoryGateway;

    public void updateCategory(Integer id, CategoryDomain categoryDomain) {
        categoryGateway.updateCategory(id, categoryDomain)
                .orElseThrow(() -> new ObjectNotFoundException("Category not found!"));
    }
}