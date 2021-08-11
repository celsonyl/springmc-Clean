package com.nyller.springmcclean.domain;

import lombok.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
public class ProductDomain implements Serializable {

    private Integer id;
    private String name;
    private Double price;
    private List<CategoryDomain> categories = new ArrayList<>();

    public ProductDomain() {
    }

    public ProductDomain(Integer id, String name, Double price, List<CategoryDomain> categories) {
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

    public List<CategoryDomain> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDomain> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDomain that = (ProductDomain) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
