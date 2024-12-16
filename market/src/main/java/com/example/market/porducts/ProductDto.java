package com.example.market.porducts;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private Category category;
    public ProductDto(Product product) {
        this.name=product.getName();
        this.description=product.getDescription();
        this.price=product.getPrice();
        this.stockQuantity=product.getStockQuantity();
        this.category=product.getCategory();
    }
}
