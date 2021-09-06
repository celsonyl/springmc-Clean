package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.exceptions.DataIntegrityException;
import com.nyller.springmcclean.gateway.DeleteCategoryByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class DeleteCategoryByIdUsecase {

    @Autowired
    private DeleteCategoryByIdGateway deleteCategoryByIdGateway;

    public void deleteCategory(Integer id) {
        try {
            deleteCategoryByIdGateway.deleteCategoryById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel deletar uma categoria que possui produtos!");
        }
    }
}