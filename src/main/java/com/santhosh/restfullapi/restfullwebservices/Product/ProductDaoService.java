package com.santhosh.restfullapi.restfullwebservices.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDaoService {
    private static List<Product> products = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllUsers() {
        return productRepository.findAll();
    }


}
