package com.tchokoapps.springboot.springcorespringmvc.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Product implements DomainObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

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
