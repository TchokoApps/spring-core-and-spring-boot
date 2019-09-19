package com.tchokoapps.springboot.springcorespringmvc.controllers;

import com.tchokoapps.springboot.springcorespringmvc.domain.Product;
import com.tchokoapps.springboot.springcorespringmvc.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotNull;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.listAllProducts());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }

    @GetMapping("/product/new")
    public String createNewProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productform";
    }

    @PostMapping("/product")
    public String saveOrUpdateProduct(@NotNull Product product) {
        Product savedProduct = productService.saveOrUpdate(product);
        return "redirect:/product/" + savedProduct.getId();
    }
}


