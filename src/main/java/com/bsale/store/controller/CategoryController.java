package com.bsale.store.controller;

import com.bsale.store.entity.Category;
import com.bsale.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("categories")
    public List<Category> GetCategories(){
        return categoryService.getAllCategories();
    }
}
