package com.postech.adapter.driver.api.controller;

import com.postech.core.application.services.ProductService;
import com.postech.core.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    void criarProdutos(@RequestBody Product product){
        productService.createNewProduct(product);
    }

    @GetMapping
    void getProdutos(){
        productService.getAllProducts();
    }

}
