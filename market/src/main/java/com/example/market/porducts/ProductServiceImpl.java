package com.example.market.porducts;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl extends ProductService {
    private ProductRepository repo;
    @Autowired
    public ProductServiceImpl(ProductRepository repo) { this.repo = repo; }

    // 판매자에 폼 형태로 입력받아 상품 등록
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product Entity = new Product(productDto);
        repo.saveAndFlush(Entity);
        return  new ProductDto(repo.findById(Entity.getId()).orElseThrow());
    }

    // ID를 입력받으면 판매자에게 자세한 페이지 출력
    @Override
    public ProductDto getProductById(Long id) {
        return  new ProductDto(repo.findById(id).orElseThrow());
    }

    //
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

    // 사용자가 선택한 카테코리로 조회
    @Override
    public List<ProductDto> listByCategory(Category category) {
        List<ProductDto> products= new ArrayList<>();
        List<Product> Entity= repo.findByCategory(category);
        if(repo.existsByCategory(category)){
            for(Product p : Entity){
                products.add(new ProductDto(p));
            }
        }else throw new EntityNotFoundException();
        return products;
    }

    // 사용자가 입력한 이름이 포함된 물품 조회
    @Override
    public List<ProductDto> listByLikeName(String name) {
        List<ProductDto> products= new ArrayList<>();
        if(repo.existsByName(name)){
            List<Product> Entity = repo.findByNameContaining(name);
            for(Product p : Entity){
                products.add(new ProductDto(p));
            }
        }else throw new EntityNotFoundException();

        return products;
    }
}
