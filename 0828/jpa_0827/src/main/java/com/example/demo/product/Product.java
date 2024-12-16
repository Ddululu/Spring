package com.example.demo.product;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.member.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	@Id   //pk 정의
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String name;
	private int price;
	private int amount;
	
	@ManyToOne  
	@JoinColumn(nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Member seller;
	private String img;//상품 이미지 경로
}
