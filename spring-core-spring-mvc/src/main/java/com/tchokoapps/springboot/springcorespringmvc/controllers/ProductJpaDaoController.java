package com.tchokoapps.springboot.springcorespringmvc.controllers;

import com.tchokoapps.springboot.springcorespringmvc.domain.Product;
import com.tchokoapps.springboot.springcorespringmvc.services.ProductServiceJpaDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotNull;

@Controller()
public class ProductJpaDaoController {

    private ProductServiceJpaDao productServiceJpaDao;

    public ProductJpaDaoController(ProductServiceJpaDao productServiceJpaDao) {
        this.productServiceJpaDao = productServiceJpaDao;
    }

    @GetMapping("/dao/list")
    public String listProducts(Model model) {
        model.addAttribute("products", productServiceJpaDao.listAll());
        return "dao/list";
    }

    @GetMapping("/dao/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productServiceJpaDao.getById(id));
        return "dao/product";
    }

    @GetMapping("/dao/new")
    public String createNewProduct(Model model) {
        model.addAttribute("product", new Product());
        return "dao/productform";
    }

    @PostMapping("/dao")
    public String saveOrUpdateProduct(@NotNull Product product) {
        Product savedProduct = productServiceJpaDao.saveOrUpdate(product);
        return "redirect:/dao/" + savedProduct.getId();
    }

    @GetMapping("/dao/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("product", productServiceJpaDao.getById(id));
        return "dao/productform";
    }

    @GetMapping("/dao/delete/{id}")
    public String delete(@PathVariable Long id) {
        productServiceJpaDao.delete(id);
        return "redirect:/dao/list";
    }
}
