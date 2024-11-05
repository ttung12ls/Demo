package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

@Entity
public class ParentCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parent_id;
    @Column (name = "name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentCategory")
    private List<Categories> categories;

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }


}


