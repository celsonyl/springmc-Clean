package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.CategoryRequest;
import com.nyller.springmcclean.controller.model.CategoryResponse;
import com.nyller.springmcclean.translator.CategoryMapperImpl;
import com.nyller.springmcclean.usecase.CreateCategoryUsecase;
import com.nyller.springmcclean.usecase.GetAllCategoriesUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CreateCategoryUsecase createCategoryUsecase;

    @Autowired
    private GetAllCategoriesUsecase getAllCategoriesUsecase;

    @PostMapping
    public ResponseEntity<Void> createCategory(@RequestBody CategoryRequest categoryRequest, UriComponentsBuilder uriComponentsBuilder) {
        var categoryMapper = new CategoryMapperImpl();
        var category = createCategoryUsecase.execute(categoryMapper.categoryRequestToDomain(categoryRequest));
        URI uri = uriComponentsBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> listCategories() {
        var categoryMapper = new CategoryMapperImpl();
        var categories = getAllCategoriesUsecase.execute();

        return ResponseEntity.ok().body(categories.stream()
                .map(categoryMapper::categoryDomainToResponse)
                .collect(Collectors.toList()));
    }
}