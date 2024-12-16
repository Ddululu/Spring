package com.example.product.vo;

import com.example.product.data.entity.Member;
import com.example.product.data.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductVO {
    private int num;
    private String name;
    private int price;
    private int amount;
    private Member seller;
    private String img;

    public ProductVO(Product product) {
        this.num = product.getNum();
        this.name = product.getName();
        this.price = product.getPrice();
        this.amount = product.getAmount();
        this.seller = product.getSeller();
        this.img = product.getImg();
    }
}
