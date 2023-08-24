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

    public static final String GET_CARTDATA =
            """
                SELECT c.id c.user_id, p.product_name, p.product_price, p.product_image from user_cart c
                JOIN product_details p ON c.product_id = p.id where c.user_id = ? AND c.is_bought = 0;
            """;

    public static String UPDATE_IS_BOUGHT =
            """
               UPDATE user_cart SET is_bought = 1 WHERE (id = ?);
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

    public boolean checkoutCart(Map<String, Object> requestBody) {
        List<Integer> ids = (List<Integer>) requestBody.get("cartIds");
        for (int i: ids) {
            cartJdbcTemplate.update(UPDATE_IS_BOUGHT, i);
        }

        return true;
    }
}
