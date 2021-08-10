package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.CategoryDomain;
import com.nyller.springmcclean.domain.exceptions.ObjectNotFoundException;
import com.nyller.springmcclean.gateway.GetCategoryByIdGateway;
import com.nyller.springmcclean.gateway.h2database.repository.CategoryRepository;
import com.nyller.springmcclean.translator.CategoryMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetCategoryByIdGatewayImpl implements GetCategoryByIdGateway {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Optional<CategoryDomain> execute(Integer id) {
        var categoryMapper = new CategoryMapperImpl();
        var category = categoryRepository.findById(id);

        if (category.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(categoryMapper.categoryDatabaseToDomain(category.get()));
    }
}
