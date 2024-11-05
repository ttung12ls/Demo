package com.example.demo.Controller;

import com.example.demo.Entity.Categories;
import com.example.demo.dto.request.CategoryCreationRequest;
import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping
    Categories createCategory(@RequestBody CategoryCreationRequest request) {
        return categoryService.createCategory(request);
    }
    @GetMapping
    List<Categories> getAllCategories() {
        return categoryService.getAllCategories();
    }
    @GetMapping("/{categoryId}")
    Categories getCategoryById(@PathVariable("categoryId") Integer categoryId) {
    return categoryService.getCategory(categoryId);
    }
    @DeleteMapping("/{categoryId}")
    String deleteCategory(@PathVariable("categoryId") Integer categoryId) {
    categoryService.deleteCategory(categoryId);
    return "Category deleted";
    }
}
