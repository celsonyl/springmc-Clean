package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.CategoryDomain;
import com.nyller.springmcclean.domain.exceptions.DataIntgrityViolation;
import com.nyller.springmcclean.gateway.CreateCategoryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryUsecase {

    @Autowired
    private CreateCategoryGateway createCategoryGateway;

    public CategoryDomain execute(CategoryDomain categoryDomain) {
        try {
            return createCategoryGateway.execute(categoryDomain);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntgrityViolation("Já existe uma categoria com esse nome! "+ categoryDomain.getName());
        }
    }
}
