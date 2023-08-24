package com.santhosh.restfullapi.restfullwebservices.Cart;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="user_cart")
public class Cart {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer productId;

    private Integer isBought;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getIsBought() {
        return isBought;
    }

    public void setIsBought(Integer isBought) {
        this.isBought = isBought;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Cart(Integer id, Integer productId, Integer isBought, Integer userId) {
        this.id = id;
        this.productId = productId;
        this.isBought = isBought;
        this.userId = userId;
    }

    public Cart() {}
}
