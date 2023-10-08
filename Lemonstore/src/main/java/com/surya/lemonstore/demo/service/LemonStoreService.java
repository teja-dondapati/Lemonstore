package com.surya.lemonstore.demo.service;

import com.surya.lemonstore.demo.repository.ProductRepository;
import com.surya.lemonstore.demo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.surya.lemonstore.demo.model.*;
import java.util.List;
import java.util.Optional;

@Service
public class LemonStoreService {

    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;

    @Autowired
    public LemonStoreService(ProductRepository productRepository, SaleRepository saleRepository) {
        this.productRepository = productRepository;
        this.saleRepository = saleRepository;
    }

    // Product CRUD operations

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    // Sale CRUD operations

    public Sale addSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Optional<Sale> getSaleById(Long saleId) {
        return saleRepository.findById(saleId);
    }

    public void deleteSale(Long saleId) {
        saleRepository.deleteById(saleId);
    }
}