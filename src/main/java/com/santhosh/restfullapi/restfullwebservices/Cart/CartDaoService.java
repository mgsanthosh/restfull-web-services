package com.santhosh.restfullapi.restfullwebservices.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class CartDaoService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private JdbcTemplate cartJdbcTemplate;

    private static String GET_CARTDATA =
            """
                SELECT c.user_id, p.product_name, p.product_price, p.product_image from user_cart c
                JOIN product_details p ON c.product_id = p.id where c.user_id = ?;
            """;



    public boolean addToCart(Integer prdId, Integer userId) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setProductId(prdId);
        cart.setIsBought(0);
        cartRepository.save(cart);
        return true;
    }

    public List<Map<String, Object>> getCartDetails(int userId) {
        List<Map<String, Object>> allCartData = new ArrayList<>();
        allCartData = cartJdbcTemplate.queryForList(GET_CARTDATA, userId);
        return allCartData;
    }
}
