package com.example.product.data.dao;

import com.example.product.data.dto.ProductDTO;
import com.example.product.vo.ProductVO;

import java.util.List;

public interface ProductDAO {
    void productAdd(ProductDTO DTO);
    void productUpdate(ProductDTO DTO);
    void productDelete(String name);
    List<ProductDTO> productList();
    List<ProductVO> getAllProducts();
    void editProduct(ProductDTO DTO);
    ProductVO getByName(ProductDTO DTO);
    List<ProductVO> getBySeller(ProductDTO DTO);
    List<ProductVO> getLowerPrice(ProductDTO DTO);

}
