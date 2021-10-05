package com.nyller.springmcclean.gateway.mysql;

import com.nyller.springmcclean.domain.CategoryDomain;
import com.nyller.springmcclean.gateway.GetAllCategoriesGateway;
import com.nyller.springmcclean.gateway.mysql.repository.CategoryRepository;
import com.nyller.springmcclean.translator.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllCategoriesGatewayImpl implements GetAllCategoriesGateway {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDomain> execute() {
        var categoryMapper = new CategoryMapper();
        var categories = categoryRepository.findAll();

        return categories.stream()
                .map(categoryMapper::categoryDatabaseToDomain)
                .collect(Collectors.toList());
    }
}
