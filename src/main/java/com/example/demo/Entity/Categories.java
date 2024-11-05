package com.example.demo.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    @Column (name = "name")
    private String name;
    @Column (name = "description")
    private String description;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private ParentCategories parentCategory;
    @CreationTimestamp
    private LocalDateTime created_at;
    @Column (name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updated_at;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<Posts> posts;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ParentCategories getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ParentCategories parentCategory) {
        this.parentCategory = parentCategory;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }
}