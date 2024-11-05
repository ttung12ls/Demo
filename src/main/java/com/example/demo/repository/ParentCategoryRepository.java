package com.example.demo.repository;

import com.example.demo.Entity.Categories;
import com.example.demo.Entity.ParentCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentCategoryRepository extends JpaRepository<ParentCategories, Integer> {
}
