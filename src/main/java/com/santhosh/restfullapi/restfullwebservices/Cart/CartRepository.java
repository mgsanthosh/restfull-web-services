package com.santhosh.restfullapi.restfullwebservices.Cart;

import com.santhosh.restfullapi.restfullwebservices.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository  extends JpaRepository<Cart, Integer> {
}
