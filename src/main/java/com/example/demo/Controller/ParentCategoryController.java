package com.example.demo.Controller;

import com.example.demo.Entity.ParentCategories;
import com.example.demo.dto.request.ParentCategoryCreationRequest;
import com.example.demo.service.ParentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parentcategories")
public class ParentCategoryController {
        @Autowired
        private ParentCategoryService parentCategoryService;
        @PostMapping
        ParentCategories createParentCategory(@RequestBody ParentCategoryCreationRequest request) {
            return parentCategoryService.createParentCategory(request);
        }
        @GetMapping
        List<ParentCategories> getAllParentCategories() {
            return parentCategoryService.getAllParentCategories();
        }
        @GetMapping("/{parentId}")
        ParentCategories getParentCategory(@PathVariable("parentId") Integer parentId) {
            return parentCategoryService.getParentCategory(parentId);
        }
        @DeleteMapping("/{parentId}")
        String deleteParentCategory(@PathVariable("parentId") Integer parentId) {
            parentCategoryService.deleteParentCategory(parentId);
            return "Deleted";
        }
    }

