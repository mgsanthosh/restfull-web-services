package com.santhosh.restfullapi.restfullwebservices.Cart;

import com.santhosh.restfullapi.restfullwebservices.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
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

    @PostMapping(path = "/checkoutCart")
    public boolean createUser(@RequestBody Map<String, Object> requestBody) {
        return cartDaoService.checkoutCart(requestBody);
    }
}
