package com.santhosh.restfullapi.restfullwebservices.Cart;

import com.santhosh.restfullapi.restfullwebservices.Product.Product;
import com.santhosh.restfullapi.restfullwebservices.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartDaoService {
    @Autowired
    private CartRepository cartRepository;

    public boolean addToCart(Integer prdId, Integer userId) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setProductId(prdId);
        cart.setIsBought(0);
        cartRepository.save(cart);
        return true;
    }
}
