package com.santhosh.restfullapi.restfullwebservices.Cart;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="user_cart")
public class Cart {
    @Id
    @GeneratedValue
    private Integer id;
    private String productId;

    private Integer isBought;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getIsBought() {
        return isBought;
    }

    public void setIsBought(Integer isBought) {
        this.isBought = isBought;
    }

    public Cart(Integer id, String productId, Integer isBought) {
        this.id = id;
        this.productId = productId;
        this.isBought = isBought;
    }

    public Cart() {}
}
