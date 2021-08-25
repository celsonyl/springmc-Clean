package com.nyller.springmcclean.domain;

import lombok.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
public class CategoryDomain implements Serializable {

    private Integer id;
    private String name;
    private List<ProductDomain> productDomainList = new ArrayList<>();

    public CategoryDomain() {
    }

    public CategoryDomain(Integer id, String name, List<ProductDomain> productDomainList) {
        this.id = id;
        this.name = name;
        this.productDomainList = productDomainList;
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

    public List<ProductDomain> getProductDomainList() {
        return productDomainList;
    }

    public void setProductDomainList(List<ProductDomain> productDomainList) {
        this.productDomainList = productDomainList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDomain that = (CategoryDomain) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}