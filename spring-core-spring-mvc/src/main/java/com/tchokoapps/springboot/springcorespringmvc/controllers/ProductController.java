package com.tchokoapps.springboot.springcorespringmvc.controllers;

import com.tchokoapps.springboot.springcorespringmvc.domain.Product;
import com.tchokoapps.springboot.springcorespringmvc.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotNull;

@Controller()
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/list")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.listAllProducts());
        return "product/list";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product/product";
    }

    @GetMapping("/product/new")
    public String createNewProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/product/productform";
    }

    @PostMapping("/product")
    public String saveOrUpdateProduct(@NotNull Product product) {
        Product savedProduct = productService.saveOrUpdate(product);
        return "redirect:/product/" + savedProduct.getId();
    }

    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product/productform";
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/product/list";
    }
}



