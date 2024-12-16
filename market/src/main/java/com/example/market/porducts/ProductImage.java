package com.example.market.porducts;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "product_image")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product id;

    @Column(nullable = false)
    private byte[] image;

    @Column(nullable = true, length = 255)
    private String altText;
}