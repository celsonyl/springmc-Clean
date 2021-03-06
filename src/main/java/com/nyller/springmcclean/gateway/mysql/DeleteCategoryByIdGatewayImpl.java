package com.nyller.springmcclean.gateway.mysql;

import com.nyller.springmcclean.gateway.DeleteCategoryByIdGateway;
import com.nyller.springmcclean.gateway.mysql.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCategoryByIdGatewayImpl implements DeleteCategoryByIdGateway {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }
}