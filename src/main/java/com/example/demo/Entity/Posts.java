package com.example.demo.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Posts {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int post_id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Categories categories;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Users users;

    @Column (name = "status")
    private String status;
    @Column (name = "created_at")
    @CreationTimestamp
    private LocalDateTime created_at;
    @Column (name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updated_at;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "posts")
    private List<Comments> comments;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "posts")
    private List<PostTags> posttags;

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
