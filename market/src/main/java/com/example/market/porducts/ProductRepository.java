package com.example.market.porducts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>
{
    boolean existsByName(String name);
    boolean existsByCategory(Category category);

    List<Product> findByCategory(Category category);
    List<Product> findByNameContaining(String name);

}
