package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.CategoryDomain;
import com.nyller.springmcclean.gateway.GetAllCategoriesGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllCategoriesUsecase {

    @Autowired
    private GetAllCategoriesGateway getAllCategoriesGateway;

    public List<CategoryDomain> execute() {
        return getAllCategoriesGateway.execute();
    }
}
