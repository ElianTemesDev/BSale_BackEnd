package com.bsale.store.controller;

import com.bsale.store.dto.CategoryDTO;
import com.bsale.store.entity.Category;
import com.bsale.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @CrossOrigin(origins = "*")
    @GetMapping("categories")
    public List<Category> getCategories() { return categoryService.getAllCategories(); }
    @CrossOrigin(origins = "*")
    @GetMapping("category/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable("id") long id) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }
}
