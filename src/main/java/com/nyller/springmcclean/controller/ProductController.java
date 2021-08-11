package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.ProductRequest;
import com.nyller.springmcclean.translator.ProductMapperImpl;
import com.nyller.springmcclean.usecase.CreateProductUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private CreateProductUsecase createProductUsecase;

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductRequest productRequest, UriComponentsBuilder uriComponentsBuilder) {
        var productMapper = new ProductMapperImpl();

        var product = createProductUsecase.execute(productMapper.productRequestToDomain(productRequest));
        var uri = uriComponentsBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}