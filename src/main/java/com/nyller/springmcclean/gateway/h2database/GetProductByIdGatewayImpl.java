package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.ProductDomain;
import com.nyller.springmcclean.gateway.GetProductByIdGateway;
import com.nyller.springmcclean.gateway.h2database.repository.ProductRepository;
import com.nyller.springmcclean.translator.ProductMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetProductByIdGatewayImpl implements GetProductByIdGateway {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<ProductDomain> execute(Integer id) {
        var productMapper = new ProductMapperImpl();
        var product = productRepository.findById(id);

        if (product.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(productMapper.productDatabaseToDomain(product.get()));
    }
}