package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.CategoryRequest;
import com.nyller.springmcclean.translator.CategoryMapperImpl;
import com.nyller.springmcclean.usecase.CreateCategoryUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CreateCategoryUsecase createCategoryUsecase;

    @PostMapping
    public ResponseEntity<Void> createCategory(@RequestBody CategoryRequest categoryRequest, UriComponentsBuilder uriComponentsBuilder) {
        var categoryMapper = new CategoryMapperImpl();
        var category = createCategoryUsecase.execute(categoryMapper.categoryRequestToDomain(categoryRequest));
        URI uri = uriComponentsBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri();
        
        return ResponseEntity.created(uri).build();
    }
}
