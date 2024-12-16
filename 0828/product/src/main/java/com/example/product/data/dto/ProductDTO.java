package com.example.product.data.dto;

import com.example.product.data.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private int price;
    private int amount;
    private Member seller;
    private String img;
}

