package com.santhosh.restfullapi.restfullwebservices.Product;

import com.santhosh.restfullapi.restfullwebservices.User.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class ProductResource {

    @Autowired
    private ProductDaoService productDaoService;
    @GetMapping(path = "/getAllProducts")
    public List<Product> getAllProducts() {
        return productDaoService.getAllProducts();
    }
}
