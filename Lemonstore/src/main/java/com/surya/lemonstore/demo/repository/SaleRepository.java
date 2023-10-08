package com.surya.lemonstore.demo.repository;

import com.surya.lemonstore.demo.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}