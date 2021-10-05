package com.nyller.springmcclean.gateway.mysql.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemOrderPK implements Serializable {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderDatabase orderDatabase;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDatabase productDatabase;

    public OrderDatabase getOrderDatabase() {
        return orderDatabase;
    }

    public void setOrderDatabase(OrderDatabase orderDatabase) {
        this.orderDatabase = orderDatabase;
    }

    public ProductDatabase getProductDatabase() {
        return productDatabase;
    }

    public void setProductDatabase(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemOrderPK that = (ItemOrderPK) o;
        return Objects.equals(orderDatabase, that.orderDatabase) && Objects.equals(productDatabase, that.productDatabase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDatabase, productDatabase);
    }
}