package com.tchokoapps.springboot.springcorespringmvc.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal price;
    private String imageUrl;

    public Product() {
    }

    public Product(Long id, String description, BigDecimal price, String imageUrl) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Product(String description, BigDecimal price, String imageUrl) {
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
