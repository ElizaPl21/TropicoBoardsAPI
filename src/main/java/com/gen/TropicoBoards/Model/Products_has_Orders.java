package com.gen.TropicoBoards.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Products_has_Orders")
public class Products_has_Orders implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "Orders_id_orders")
    private Orders orders;

    @Id
    @ManyToOne
    @JoinColumn(name = "Products_id_products")
    private Products products;

    @Column(name = "quantity", nullable = false)
    private Long quantity;
    
    // Constructor vacío 
    public Products_has_Orders() {
        
    }

    //Contructores
    public Products_has_Orders(Orders orders, Products products, Long quantity) {
        this.orders = orders;
        this.products = products;
        this.quantity = quantity;
    }

    public Orders getOrder() {
        return orders;
    }

    public void setOrder(Orders orders) {
        this.orders = orders;
    }

    public Products getProduct() {
        return products;
    }

    public void setProduct(Products products) {
        this.products = products;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products_has_Orders that = (Products_has_Orders) o;
        return quantity == that.quantity &&
                Objects.equals(orders, that.orders) &&
                Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders, products, quantity);
    }
}