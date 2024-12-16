package com.example.product.service;

import com.example.product.data.entity.Member;
import com.example.product.data.repository.ProductRepository;
import com.example.product.data.dto.ProductDTO;
import com.example.product.data.entity.Product;
import com.example.product.vo.ProductVO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository repo;

    @Autowired
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    //add
    public void productAdd(ProductDTO DTO) {
        repo.save(new Product(DTO));
    }

    //list
    public List<ProductVO> getAllProducts() {
        List<ProductVO> products = new ArrayList<>();
        List<Product> Entity = repo.findAll();
        for (Product p : Entity) {
            products.add(new ProductVO(p));
        }
        return products;
    }

    //update
    public void editProduct(ProductDTO DTO) {
        if (scanItem(DTO)) {
            Product product = repo.findByName(DTO.getName()).get();
            product.setAmount(DTO.getAmount());
            product.setPrice(DTO.getPrice());
            product.setPrice(DTO.getPrice());
            product.setSeller(DTO.getSeller());
            repo.save(product);
        } else throw new EntityNotFoundException();
    }

    //findbyname
    public ProductVO getByName(ProductDTO DTO) {
        if (scanItem(DTO)) {
            return new ProductVO(repo.findByName(DTO.getName()).get());
        }
        return new ProductVO();
    }

    //findbyseller
    public List<ProductVO> getBySeller(String id) {
        List<ProductVO> products= new ArrayList<>();
        Member member = new Member();
        member.setId(id);
        if (scanSeller(member)) {
            List<Product> Entity= repo.findBySeller(member);
            for (Product p : Entity) {
                products.add(new ProductVO(p));
            }
        }
        return products;
    }

//findbypriceLessthan
    public List<ProductVO> getLowerPrice(ProductDTO DTO) {
        List<ProductVO> products= new ArrayList<>();
        List<Product> Entity= repo.findByPriceLessThan(DTO.getPrice());
        for (Product p : Entity) {
            products.add(new ProductVO(p));
        }
        return products;
    }

    //findExist
    private Boolean scanItem(ProductDTO DTO) {
        return repo.existsByName(DTO.getName());
    }
    private Boolean scanSeller(Member seller) {
        return repo.existsBySeller(seller);
    }

    //delete
    public void deleteProduct(ProductDTO DTO) {
        repo.findByName(DTO.getName())
                .ifPresentOrElse(
                        Entity -> {repo.delete(Entity);},
                        ()->{throw new EntityNotFoundException("상품 삭제 실패");});
    }
}
