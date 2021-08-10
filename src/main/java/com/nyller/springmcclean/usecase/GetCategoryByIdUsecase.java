package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.CategoryDomain;
import com.nyller.springmcclean.domain.exceptions.ObjectNotFoundException;
import com.nyller.springmcclean.gateway.GetCategoryByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetCategoryByIdUsecase {

    @Autowired
    private GetCategoryByIdGateway getCategoryByIdGateway;

    public CategoryDomain execute(Integer id) {
        return getCategoryByIdGateway.execute(id)
                .orElseThrow(() -> new ObjectNotFoundException("Category not found! " + id));
    }
}
