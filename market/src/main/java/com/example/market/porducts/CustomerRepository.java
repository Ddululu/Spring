package com.example.market.porducts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
    boolean existsByCategory(Category category);

    List<Product> findByName(String name);
    boolean existsByName(String name);
}
