package com.surya.lemonstore.demo.service;

import com.surya.lemonstore.demo.model.Product;
import com.surya.lemonstore.demo.repository.ProductRepository;
import com.surya.lemonstore.demo.service.LemonStoreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LemonStoreServiceTest {

    private LemonStoreService lemonStoreService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        lemonStoreService = new LemonStoreService(productRepository);
    }

    @Test
    public void testAddProduct() {
        // Arrange
        Product productToSave = new Product();
        productToSave.setName("New Product");
        productToSave.setPrice(29.99);

        when(productRepository.save(productToSave)).thenReturn(productToSave);

        // Act
        Product savedProduct = lemonStoreService.addProduct(productToSave);

        // Assert
        assertEquals(productToSave.getName(), savedProduct.getName());
        assertEquals(productToSave.getPrice(), savedProduct.getPrice(), 0.001); // Allow for a small difference in double values
    }

    @Test
    public void testGetAllProducts() {
        // Arrange
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L, "Product 1", 19.99));
        productList.add(new Product(2L, "Product 2", 29.99));

        when(productRepository.findAll()).thenReturn(productList);

        // Act
        List<Product> result = lemonStoreService.getAllProducts();

        // Assert
        assertEquals(productList.size(), result.size());
        for (int i = 0; i < productList.size(); i++) {
            assertEquals(productList.get(i), result.get(i));
        }
    }

    // Add more test methods to cover other service methods as needed
}
