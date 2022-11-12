package com.bsale.store.controller;

import com.bsale.store.entity.Product;
import com.bsale.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public List<Product> GetProducts(){
        return productService.getAllProducts();
    }
}
