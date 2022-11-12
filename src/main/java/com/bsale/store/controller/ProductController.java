package com.bsale.store.controller;

import com.bsale.store.dto.ProductDTO;
import com.bsale.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public List<ProductDTO> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("product")
    public ResponseEntity<List<ProductDTO>> searchProductByNameAndCategory(@RequestParam("name") String name, @RequestParam("category") long id){
        return new ResponseEntity<>(productService.searchProductByNameAndCategory(name, id), HttpStatus.OK);
    }

    @GetMapping("product")
    public ResponseEntity<List<ProductDTO>> searchProductByName(@RequestParam("name") String name){
        return new ResponseEntity<>(productService.searchProductByName(name), HttpStatus.OK);
    }
}
