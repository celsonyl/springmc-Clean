package com.nyller.springmcclean.gateway.mysql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "product")
@Builder
public class ProductDatabase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryDatabase> categories = new ArrayList<>();

    @OneToMany(mappedBy = "id.productDatabase")
    private Set<ItemOrderDatabase> itens = new HashSet<>();

    public ProductDatabase() {
    }

    public ProductDatabase(Integer id, String name, Double price, List<CategoryDatabase> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = categories;
    }

    public ProductDatabase(Integer id, String name, Double price, List<CategoryDatabase> categories, Set<ItemOrderDatabase> itens) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = categories;
        this.itens = itens;
    }

    public List<OrderDatabase> getOrderDatabases() {
        List<OrderDatabase> list = new ArrayList<>();
        for (ItemOrderDatabase x : itens) {
            list.add(x.getOrder());
        }
        return list;
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

    public List<CategoryDatabase> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDatabase> categories) {
        this.categories = categories;
    }

    public Set<ItemOrderDatabase> getItens() {
        return itens;
    }

    public void setItens(Set<ItemOrderDatabase> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDatabase that = (ProductDatabase) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
