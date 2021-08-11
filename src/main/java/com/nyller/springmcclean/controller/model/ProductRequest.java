package com.nyller.springmcclean.controller.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductRequest implements Serializable {

    private Integer id;

    @NotBlank(message = "Campo nome não pode ser vazio ou nulo!")
    private String name;

    @NotNull(message = "Campo preço não pode ser nulo!")
    @PositiveOrZero
    private Double price;

    @NotNull(message = "Campo categories não pode ser nulo!")
    private List<CategoryRequest> categories = new ArrayList<>();

    public ProductRequest() {
    }

    public ProductRequest(Integer id, String name, Double price, List<CategoryRequest> categories) {
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

    public List<CategoryRequest> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryRequest> categories) {
        this.categories = categories;
    }
}