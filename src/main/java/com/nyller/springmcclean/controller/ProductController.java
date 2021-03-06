package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.ProductRequest;
import com.nyller.springmcclean.controller.model.ProductResponse;
import com.nyller.springmcclean.translator.ProductMapperImpl;
import com.nyller.springmcclean.usecase.CreateProductUsecase;
import com.nyller.springmcclean.usecase.DeleteProductByIdUsecase;
import com.nyller.springmcclean.usecase.GetAllProductsUsecase;
import com.nyller.springmcclean.usecase.GetProductByIdUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private CreateProductUsecase createProductUsecase;
    @Autowired
    private GetProductByIdUsecase getProductByIdUsecase;
    @Autowired
    private GetAllProductsUsecase getAllProductsUsecase;
    @Autowired
    private DeleteProductByIdUsecase deleteProductByIdUsecase;

    @PostMapping
    public ResponseEntity<Void> createProduct(@Valid @RequestBody ProductRequest productRequest, UriComponentsBuilder uriComponentsBuilder) {
        var productMapper = new ProductMapperImpl();

        var product = createProductUsecase.execute(productMapper.productRequestToDomain(productRequest));
        var uri = uriComponentsBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Integer id) {
        var productMapper = new ProductMapperImpl();
        var product = getProductByIdUsecase.execute(id);

        return ResponseEntity.ok().body(productMapper.productDomainToResponse(product));
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        var productMapper = new ProductMapperImpl();
        var product = getAllProductsUsecase.execute();

        return ResponseEntity.ok().body(product.stream()
                .map(productMapper::productDomainToResponse)
                .collect(Collectors.toList()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Integer id) {
        deleteProductByIdUsecase.execute(id);
        return ResponseEntity.noContent().build();
    }
}