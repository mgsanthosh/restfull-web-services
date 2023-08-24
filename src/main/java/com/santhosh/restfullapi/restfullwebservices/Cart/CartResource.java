package com.santhosh.restfullapi.restfullwebservices.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartResource {

    @Autowired
    private CartDaoService cartDaoService;

    @GetMapping(path = "/addToCart/{productId}/{userId}")
    public boolean addToCart(@PathVariable Integer productId, @PathVariable Integer userId) {
        return cartDaoService.addToCart(productId, userId);
    }
}
