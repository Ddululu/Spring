package com.example.market.porducts;

import java.util.List;

public class SellerServiceImpl extends SellerService {

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public void updateStock(Long id, int newStockQuantity) {

    }

    @Override
    public void updatePrice(Long id, double newPrice) {

    }
}
