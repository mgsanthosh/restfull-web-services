package com.santhosh.restfullapi.restfullwebservices.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CartResource {

    @Autowired
    private CartDaoService cartDaoService;

    @GetMapping(path = "/addToCart/{productId}/{userId}")
    public boolean addToCart(@PathVariable Integer productId, @PathVariable Integer userId) {
        return cartDaoService.addToCart(productId, userId);
    }

    @GetMapping(path = "getUserCartData/{userId}")
    public List<Map<String,Object>> getUserCartData(@PathVariable int userId) {
        return cartDaoService.getCartDetails(userId);
    }
}
