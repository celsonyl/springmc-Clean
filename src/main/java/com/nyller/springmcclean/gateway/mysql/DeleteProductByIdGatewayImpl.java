package com.nyller.springmcclean.gateway.mysql;

import com.nyller.springmcclean.gateway.DeleteProductByIdGateway;
import com.nyller.springmcclean.gateway.mysql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductByIdGatewayImpl implements DeleteProductByIdGateway {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void execute(Integer id) {
        productRepository.deleteById(id);
    }
}
