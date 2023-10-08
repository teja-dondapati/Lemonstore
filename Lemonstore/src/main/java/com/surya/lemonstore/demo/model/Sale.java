package com.surya.lemonstore.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleId;

    @ManyToOne
    private Product product;

    private int quantity;

    private double totalAmount;

    private LocalDateTime timestamp;

    // Constructors (if needed)

    // Getter for saleId
    public Long getSaleId() {
        return saleId;
    }

    // Setter for saleId
    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    // Getter for product
    public Product getProduct() {
        return product;
    }

    // Setter for product
    public void setProduct(Product product) {
        this.product = product;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter for totalAmount
    public double getTotalAmount() {
        return totalAmount;
    }

    // Setter for totalAmount
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // Getter for timestamp
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Setter for timestamp
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
