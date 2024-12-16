package com.example.product.data.entity;

import com.example.product.data.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;

    @Column(unique=true, nullable=false)
    private String name;

    private int price;

    private int amount;

    @ManyToOne // Member id = Product Seller
    @JoinColumn(nullable=false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Member seller;
    private String img;
    // private MultipartFile image;


    public Product(ProductDTO dto){
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.amount = dto.getAmount();
        this.img = dto.getImg();
        this.seller = dto.getSeller();
    }
}
