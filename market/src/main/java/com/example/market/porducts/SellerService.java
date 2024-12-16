package com.example.market.porducts;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class SellerService {
    public abstract ProductDto createProduct(ProductDto productDto);

    public abstract ProductDto getProductById(Long id);

    public abstract List<ProductDto> getAllProducts();

    public abstract ProductDto updateProduct(Long id, ProductDto productDto);
    public abstract void deleteProduct(Long id);
    public abstract void updateStock(Long id, int newStockQuantity);
    public abstract void updatePrice(Long id, double newPrice);


}
