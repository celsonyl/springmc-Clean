package com.nyller.springmcclean.controller.model;

import lombok.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
public class CategoryResponse implements Serializable {

    private Integer id;
    private String name;
    private List<ProductResponse> productResponseList = new ArrayList<>();

    public CategoryResponse() {
    }

    public CategoryResponse(Integer id, String name, List<ProductResponse> productResponseList) {
        this.id = id;
        this.name = name;
        this.productResponseList = productResponseList;
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

    public List<ProductResponse> getProductResponseList() {
        return productResponseList;
    }

    public void setProductResponseList(List<ProductResponse> productResponseList) {
        this.productResponseList = productResponseList;
    }
}