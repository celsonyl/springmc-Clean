package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.CategoryDomain;
import com.nyller.springmcclean.gateway.CreateCategoryGateway;
import com.nyller.springmcclean.gateway.h2database.repository.CategoryRepository;
import com.nyller.springmcclean.translator.CategoryMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryGatewayImpl implements CreateCategoryGateway {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDomain execute(CategoryDomain categoryDomain) {
        var categoryMapper = new CategoryMapperImpl();
        var category = categoryRepository.save(categoryMapper.categoryDomainToDatabase(categoryDomain));

        return categoryMapper.categoryDatabaseToDomain(category);
    }
}
