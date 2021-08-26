package com.nyller.springmcclean.controller;

import com.nyller.springmcclean.controller.model.CategoryRequest;
import com.nyller.springmcclean.controller.model.CategoryResponse;
import com.nyller.springmcclean.translator.CategoryMapper;
import com.nyller.springmcclean.usecase.CreateCategoryUsecase;
import com.nyller.springmcclean.usecase.GetAllCategoriesUsecase;
import com.nyller.springmcclean.usecase.GetCategoryByIdUsecase;
import com.nyller.springmcclean.usecase.UpdateCategoryUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CreateCategoryUsecase createCategoryUsecase;

    @Autowired
    private GetAllCategoriesUsecase getAllCategoriesUsecase;

    @Autowired
    private GetCategoryByIdUsecase getCategoryByIdUsecase;

    @Autowired
    private UpdateCategoryUsecase updateCategoryUsecase;

    @PostMapping
    public ResponseEntity<Void> createCategory(@Valid @RequestBody CategoryRequest categoryRequest, UriComponentsBuilder uriComponentsBuilder) {
        var categoryMapper = new CategoryMapper();
        var category = createCategoryUsecase.execute(categoryMapper.categoryRequestToDomain(categoryRequest));
        var uri = uriComponentsBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCategory(@Valid @PathVariable Integer id, @RequestBody CategoryRequest categoryRequest) {
        var categoryMapper = new CategoryMapper();
        updateCategoryUsecase.updateCategory(id, categoryMapper.categoryRequestToDomain(categoryRequest));
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Integer id) {
        var categoryMapper = new CategoryMapper();
        var category = getCategoryByIdUsecase.execute(id);

        return ResponseEntity.ok().body(categoryMapper.categoryDomainToResponse(category));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> listCategories() {
        var categoryMapper = new CategoryMapper();
        var categories = getAllCategoriesUsecase.execute();

        return ResponseEntity.ok().body(categories.stream()
                .map(categoryMapper::categoryDomainToResponse)
                .collect(Collectors.toList()));
    }
}