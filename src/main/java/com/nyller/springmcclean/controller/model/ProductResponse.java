package com.nyller.springmcclean.controller.model;

import lombok.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
public class ProductResponse implements Serializable {

    private Integer id;
    private String name;
    private Double price;

    private List<CategoryResponse> categories = new ArrayList<>();

    public ProductResponse() {
    }

    public ProductResponse(Integer id, String name, Double price, List<CategoryResponse> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<CategoryResponse> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryResponse> categories) {
        this.categories = categories;
    }
}