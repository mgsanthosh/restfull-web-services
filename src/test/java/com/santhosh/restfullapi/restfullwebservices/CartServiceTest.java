package com.santhosh.restfullapi.restfullwebservices;

import com.santhosh.restfullapi.restfullwebservices.Cart.Cart;
import com.santhosh.restfullapi.restfullwebservices.Cart.CartDaoService;
import com.santhosh.restfullapi.restfullwebservices.Cart.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CartServiceTest {
    @Mock
    private CartRepository cartRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private CartDaoService cartService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetCartDetails() {
        int userId = 1;
        List<Map<String, Object>> mockResult = new ArrayList<>();
        Map<String, Object> cartData1 = new HashMap<>();
        cartData1.put("id", 1);
        cartData1.put("user_id", 1);
        cartData1.put("product_name", "Product A");
        cartData1.put("product_price", 10.0);
        cartData1.put("product_image", "image_url");
        mockResult.add(cartData1);
        when(jdbcTemplate.queryForList(CartDaoService.GET_CARTDATA, userId)).thenReturn(mockResult);
        List<Map<String, Object>> result = cartService.getCartDetails(userId);
    }

    @Test
    public void testCheckoutCart() {
        Map<String, Object> requestBody = new HashMap<>();
        List<Integer> cartIds = new ArrayList<>();
        cartIds.add(1);
        cartIds.add(2);
        cartIds.add(3);
        requestBody.put("cartIds", cartIds);
        boolean result = cartService.checkoutCart(requestBody);
        assertTrue(result); // The result is expected to be true
        for (int cartId : cartIds) {
            verify(jdbcTemplate).update(cartService.UPDATE_IS_BOUGHT, cartId);
        }
    }
}