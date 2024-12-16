package com.example.market.porducts;

import java.util.List;

public abstract class ProductService {
    public abstract ProductDto createProduct(ProductDto productDto);
    public abstract ProductDto updateProduct(Long id, ProductDto productDto);

    public abstract void updateStock(Long id, int newStockQuantity);
    public abstract void updatePrice(Long id, double newPrice);

    public abstract void deleteProduct(Long id);

    public abstract ProductDto getProductById(Long id);
    public abstract List<ProductDto> getAllProducts();
    public abstract List<ProductDto> listByCategory(Category category);
    public abstract List<ProductDto> listByLikeName(String name);
}
