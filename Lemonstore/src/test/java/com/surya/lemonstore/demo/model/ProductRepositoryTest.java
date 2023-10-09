package com.surya.lemonstore.demo.model;

import com.surya.lemonstore.demo.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        // Initialize any required setup here
    }

    @Test
    public void testFindById() {
        // Arrange
        Long productId = 1L;
        Product expectedProduct = new Product();
        expectedProduct.setProductId(productId);
        expectedProduct.setName("Test Product");
        expectedProduct.setPrice(19.99);

        // Mock the behavior of the productRepository when findById is called
        when(productRepository.findById(productId)).thenReturn(Optional.of(expectedProduct));

        // Act
        Optional<Product> result = productRepository.findById(productId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(expectedProduct, result.get());
    }

    // Add more test methods as needed
}
