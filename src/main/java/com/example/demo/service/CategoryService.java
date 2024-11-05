package com.example.demo.service;

import com.example.demo.Entity.Categories;
import com.example.demo.Entity.ParentCategories;
import com.example.demo.dto.request.CategoryCreationRequest;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ParentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private ParentCategoryRepository parentCategoriesRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    public Categories createCategory(CategoryCreationRequest request) {
        Categories category = new Categories();
        int parent_id = request.getParent_id();
        ParentCategories parentCategories = null;
        Optional<ParentCategories> parentCategoriesOpt = parentCategoriesRepository.findById(parent_id);
        if (parentCategoriesOpt.isPresent()) {
            parentCategories = parentCategoriesOpt.get();
        }
        category.setParentCategory(parentCategories);
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setCreated_at(request.getCreated_at());
        category.setUpdated_at(request.getUpdated_at());
        return categoryRepository.save(category);

    }
    public List<Categories> getAllCategories() {
        return categoryRepository.findAll();
    }
    public Categories getCategory(Integer categoryid) {
       return categoryRepository.findById(categoryid).orElseThrow(() -> new RuntimeException("Category not found"));
    }
    public void deleteCategory(Integer categoryid) {
        categoryRepository.deleteById(categoryid);
    }
}
