package com.nyller.springmcclean.gateway.h2database;

import com.nyller.springmcclean.domain.ProductDomain;
import com.nyller.springmcclean.gateway.CreateProductGateway;
import com.nyller.springmcclean.gateway.h2database.repository.ProductRepository;
import com.nyller.springmcclean.translator.ProductMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProductGatewayImpl implements CreateProductGateway {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDomain execute(ProductDomain productDomain) {
        var productMapper = new ProductMapperImpl();
        var product = productRepository.save(productMapper.productDomainToDatabase(productDomain));

        return productMapper.productDatabaseToDomain(product);
    }
}