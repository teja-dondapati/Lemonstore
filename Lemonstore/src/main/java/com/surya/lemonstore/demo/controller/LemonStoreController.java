package com.surya.lemonstore.demo.controller;

import com.surya.lemonstore.demo.*;
import com.surya.lemonstore.demo.exception.GlobalExceptionHandler;
import com.surya.lemonstore.demo.model.Product;
import com.surya.lemonstore.demo.model.Sale;
import com.surya.lemonstore.demo.service.LemonStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/cash-register")
public class LemonStoreController {

    private final LemonStoreService LemonStoreService;

    @ExceptionHandler(GlobalExceptionHandler.CustomNotFoundException.class)
    public ResponseEntity<String> handleCustomNotFoundException(GlobalExceptionHandler.CustomNotFoundException e) {
        // Handle and log the exception
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found: " + e.getMessage());
    }

    @Autowired
    public LemonStoreController(LemonStoreService LemonStoreService) {
        this.LemonStoreService = LemonStoreService;
    }

    // Product Endpoints

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return LemonStoreService.addProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return LemonStoreService.getAllProducts();
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Optional<Product> product = LemonStoreService.getProductById(productId);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            throw new GlobalExceptionHandler.CustomNotFoundException("Product with ID " + productId + " not found.");
        }
    }


    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        LemonStoreService.deleteProduct(productId);
    }

    // Sale Endpoints

    @PostMapping("/sales")
    public Sale addSale(@RequestBody Sale sale) {
        return LemonStoreService.addSale(sale);
    }

    @GetMapping("/sales")
    public List<Sale> getAllSales() {
        return LemonStoreService.getAllSales();
    }

    @GetMapping("/sales/{saleId}")
    public Optional<Sale> getSaleById(@PathVariable Long saleId) {
        return LemonStoreService.getSaleById(saleId);
    }

    @DeleteMapping("/sales/{saleId}")
    public void deleteSale(@PathVariable Long saleId) {
        LemonStoreService.deleteSale(saleId);
    }
}