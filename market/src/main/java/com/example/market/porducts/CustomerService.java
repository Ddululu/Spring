package com.example.market.porducts;

import java.util.List;

public abstract class CustomerService {
    public abstract List<ProductDto> listByCategory(Category category);

    public abstract List<ProductDto> listByName(String name);

}
