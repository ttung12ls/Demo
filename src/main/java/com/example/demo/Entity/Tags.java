package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tags {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int tag_id;
    @Column(name = "name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    private List<PostTags> posttags;

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
