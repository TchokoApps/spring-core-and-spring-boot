package com.tchokoapps.springboot.springcorespringmvc;


import com.tchokoapps.springboot.springcorespringmvc.config.JpaIntegrationConfig;
import com.tchokoapps.springboot.springcorespringmvc.domain.Product;
import com.tchokoapps.springboot.springcorespringmvc.services.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@Import(JpaIntegrationConfig.class)
public class ProductServiceJpaDaoImplTest {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void listAllProducts_shouldReturn_5_products() {
        List<Product> products = productService.listAllProducts();
        Assertions.assertThat(products.size()).isEqualTo(10);
    }
}
