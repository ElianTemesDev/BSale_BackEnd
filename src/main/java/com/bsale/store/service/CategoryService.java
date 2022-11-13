package com.bsale.store.service;

import com.bsale.store.dto.CategoryDTO;
import com.bsale.store.entity.Category;
import com.bsale.store.exception.ResourceNotFoundEx;
import com.bsale.store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    private CategoryDTO mapCategoryToCategoryDTO(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public CategoryDTO getCategoryById(long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundEx("Category", "ID", id));
        return mapCategoryToCategoryDTO(category);
    }
}
