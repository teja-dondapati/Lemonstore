package com.surya.lemonstore.demo.controller;

import com.surya.lemonstore.demo.model.Product;
import com.surya.lemonstore.demo.service.LemonStoreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class LemonStoreControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private LemonStoreService lemonStoreService;

    @BeforeEach
    public void setUp() {
        // Mock service methods as needed for testing
    }

    @Test
    public void testGetAllProducts() throws Exception {
        // Arrange
        List<Product> products = new ArrayList<>();
        products.add(new Product(4L, "Indian Lemon", 29.99));
        products.add(new Product(6L, "Nimbu", 2.9));

        when(lemonStoreService.getAllProducts()).thenReturn(products);

        // Act
        ResultActions result = mockMvc.perform(get("/api/cash-register/products")
                .contentType(MediaType.APPLICATION_JSON));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(products.size()));
    }

    @Test
    public void testGetProductById() throws Exception {
        // Arrange
        Long productId = 4L;
        String productName = "Indian Lemon";
        double productPrice = 29.99;

        Product product = new Product(productId, productName, productPrice);

        when(lemonStoreService.getProductById(productId)).thenReturn(Optional.of(product));

        // Act
        ResultActions result = mockMvc.perform(get("/api/cash-register/products/{productId}", productId)
                .contentType(MediaType.APPLICATION_JSON));

        // Debugging: Print the response content for inspection
        String responseContent = result.andReturn().getResponse().getContentAsString();
        System.out.println("Response Content: " + responseContent);

        // Assert
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.name").value(productName))
                .andExpect(jsonPath("$.price").value(productPrice));
    }

    // Add more test methods to cover other controller endpoints as needed
}
