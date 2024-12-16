package com.example.product.data.repository;

import com.example.product.data.entity.Member;
import com.example.product.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
     Optional<Product> findByName(String name);
     List<Product> findBySeller(Member seller);
     List<Product> findByPriceLessThan(int price);

     Boolean existsByName(String name);
     Boolean existsBySeller(Member seller);

}
