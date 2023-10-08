package com.surya.lemonstore.demo.repository;

import com.surya.lemonstore.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}