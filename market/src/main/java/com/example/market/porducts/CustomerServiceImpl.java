package com.example.market.porducts;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl extends CustomerService {
    private CustomerRepository repo;
    @Autowired
    public CustomerServiceImpl(CustomerRepository repo) {this.repo = repo;}

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

    @Override
    public List<ProductDto> listByName(String name) {
        List<ProductDto> products= new ArrayList<>();
        if(repo.existsByName(name)){
            List<Product> Entity = repo.findByName(name);
            for(Product p : Entity){
                products.add(new ProductDto(p));
            }
        }else throw new EntityNotFoundException();

        return products;
    }
}
