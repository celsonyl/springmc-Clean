package com.nyller.springmcclean.gateway.h2database.model;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "categories")
@Builder
public class CategoryDatabase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<ProductDatabase> products = new ArrayList<>();

    public CategoryDatabase() {
    }

    public CategoryDatabase(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDatabase(Integer id, String name, List<ProductDatabase> products) {
        this.id = id;
        this.name = name;
        this.products = products;
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

    public List<ProductDatabase> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDatabase> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDatabase that = (CategoryDatabase) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
