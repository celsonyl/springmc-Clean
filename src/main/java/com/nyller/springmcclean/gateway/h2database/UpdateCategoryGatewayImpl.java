package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.CategoryDomain;
import com.nyller.springmcclean.gateway.UpdateCategoryGateway;
import com.nyller.springmcclean.gateway.h2database.model.CategoryDatabase;
import com.nyller.springmcclean.gateway.h2database.repository.CategoryRepository;
import com.nyller.springmcclean.translator.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateCategoryGatewayImpl implements UpdateCategoryGateway {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Optional<CategoryDomain> updateCategory(Integer id, CategoryDomain categoryDomain) {
        var categoryMapper = new CategoryMapper();
        var category = categoryRepository.findById(id);

        if (category.isEmpty()) {
            return Optional.empty();
        }

        updateCategory(category.get(), categoryMapper.categoryDomainToDatabase(categoryDomain));
        var newCategory = categoryRepository.save(category.get());

        return Optional.of(categoryMapper.categoryDatabaseToDomain(newCategory));
    }

    private void updateCategory(CategoryDatabase category, CategoryDatabase newCategory) {
        category.setName(newCategory.getName());
    }
}