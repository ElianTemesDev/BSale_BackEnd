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
    @CrossOrigin(origins = "*")
    @GetMapping("products")
    public List<ProductDTO> getProducts() {
        return productService.getAllProducts();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping(value = "product", params = "name")
    public ResponseEntity<List<ProductDTO>> searchProductByName(@RequestParam("name") String name) {
        return new ResponseEntity<>(productService.searchProductByName(name.toLowerCase()), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping(value = "product", params = "category")
    public ResponseEntity<List<ProductDTO>> searchProductByCategory(@RequestParam("category") long id) {
        return new ResponseEntity<>(productService.searchProductByCategory(id), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping(value = "product", params = {"name", "category"})
    public ResponseEntity<List<ProductDTO>> searchProductByNameAndCategory(@RequestParam("name") String name, @RequestParam(value = "category", required = false) long id) {
        return new ResponseEntity<>(productService.searchProductByNameAndCategory(name.toLowerCase(), id), HttpStatus.OK);
    }
}
