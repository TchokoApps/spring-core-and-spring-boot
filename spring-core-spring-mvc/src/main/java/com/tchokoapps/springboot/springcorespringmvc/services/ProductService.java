package com.tchokoapps.springboot.springcorespringmvc.services;

import com.tchokoapps.springboot.springcorespringmvc.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProducts();

    Product getProductById(Long id);

    Product saveOrUpdate(Product product);
}
