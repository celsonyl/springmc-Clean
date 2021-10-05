package com.nyller.springmcclean.gateway.mysql;

import com.nyller.springmcclean.domain.ProductDomain;
import com.nyller.springmcclean.gateway.GetAllProductsGateway;
import com.nyller.springmcclean.gateway.mysql.repository.ProductRepository;
import com.nyller.springmcclean.translator.ProductMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllProductsGatewayImpl implements GetAllProductsGateway {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDomain> execute() {
        var productMapper = new ProductMapperImpl();
        var products = productRepository.findAll();

        return products.stream()
                .map(productMapper::productDatabaseToDomain)
                .collect(Collectors.toList());
    }
}