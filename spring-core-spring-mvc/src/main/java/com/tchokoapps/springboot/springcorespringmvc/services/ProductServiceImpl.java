package com.tchokoapps.springboot.springcorespringmvc.services;

import com.tchokoapps.springboot.springcorespringmvc.domain.Product;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private Map<Long, Product> products;

    public ProductServiceImpl() {
        loadProducts();
    }

    private void loadProducts() {
        products = new HashMap<>();

        Product product1 = new Product();
        product1.setId(1L);
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");

        products.put(1L, product1);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");

        products.put(2L, product2);

        Product product3 = new Product();
        product3.setId(3L);
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");

        products.put(3L, product3);

        Product product4 = new Product();
        product4.setId(4L);
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");

        products.put(4L, product4);

        Product product5 = new Product();
        product5.setId(5L);
        product5.setDescription("Product 2");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");

        products.put(5L, product5);
    }

    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(@NotNull Long id) {
        return products.get(id);
    }

    @Override
    public Product saveOrUpdate(@NotNull Product product) {
        if (product.getId() == null) {
            product.setId(getNextKey());
        }
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public void deleteProduct(@NotNull Long id) {
        products.remove(id);
    }

    private Long getNextKey() {
        return Collections.max(products.keySet()) + 1;
    }
}
