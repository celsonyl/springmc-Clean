package com.nyller.springmcclean.gateway.mysql.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ItemOrderDatabase implements Serializable {

    @EmbeddedId
    private ItemOrderPK id = new ItemOrderPK();

    private Double discount;
    private Integer quantity;
    private Double price;

    public ItemOrderDatabase() {
    }

    public ItemOrderDatabase(ProductDatabase product, OrderDatabase order, Double discount, Integer quantity, Double price) {
        id.setOrderDatabase(order);
        id.setProductDatabase(product);
        this.discount = discount;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductDatabase getPedido() {
        return id.getProductDatabase();
    }

    public OrderDatabase getOrder() {
        return id.getOrderDatabase();
    }

    public ItemOrderPK getId() {
        return id;
    }

    public void setId(ItemOrderPK id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemOrderDatabase that = (ItemOrderDatabase) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}