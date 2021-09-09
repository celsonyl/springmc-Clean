package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.exceptions.DataIntegrityException;
import com.nyller.springmcclean.gateway.DeleteProductByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductByIdUsecase {

    @Autowired
    private DeleteProductByIdGateway deleteProductByIdGateway;
    @Autowired
    private GetProductByIdUsecase productByIdUsecase;

    public void execute(Integer id) {
        try {
            var product = productByIdUsecase.execute(id);
            deleteProductByIdGateway.execute(product.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel deletar um produto que possui categoria!");
        }
    }
}
