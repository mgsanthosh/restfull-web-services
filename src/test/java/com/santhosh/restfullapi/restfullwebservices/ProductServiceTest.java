package com.santhosh.restfullapi.restfullwebservices;

import com.santhosh.restfullapi.restfullwebservices.Product.Product;
import com.santhosh.restfullapi.restfullwebservices.Product.ProductDaoService;
import com.santhosh.restfullapi.restfullwebservices.Product.ProductRepository;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest

public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    public ProductDaoService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        // Create mock data
        Product product1 = new Product(1, "Product 1", 10.0, "");
        Product product2 = new Product(2, "Product 2", 15.0, "");
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> result = productService.getAllProducts();
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getProductName());
        assertEquals("Product 2", result.get(1).getProductName());
    }

}