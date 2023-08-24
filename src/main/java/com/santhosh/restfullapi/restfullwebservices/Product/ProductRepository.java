package com.santhosh.restfullapi.restfullwebservices.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Integer> {
}
