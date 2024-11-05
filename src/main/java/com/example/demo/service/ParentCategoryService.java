package com.example.demo.service;

import com.example.demo.Entity.ParentCategories;
import com.example.demo.Entity.Tags;
import com.example.demo.dto.request.ParentCategoryCreationRequest;
import com.example.demo.dto.request.TagCreationRequest;
import com.example.demo.repository.ParentCategoryRepository;
import com.example.demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentCategoryService {
    @Autowired
    private ParentCategoryRepository parentCategoryRepository;

    public ParentCategories createParentCategory(ParentCategoryCreationRequest request) {
        ParentCategories parentCategory = new ParentCategories();
        parentCategory.setName(request.getName());

        return parentCategoryRepository.save(parentCategory);
    }

    public List<ParentCategories> getAllParentCategories() {
        return parentCategoryRepository.findAll();
    }

    public ParentCategories getParentCategory(Integer parentCategoryId) {
        return parentCategoryRepository.findById(parentCategoryId).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void deleteParentCategory(Integer parentCategoryId) {
        parentCategoryRepository.deleteById(parentCategoryId);
    }
}
