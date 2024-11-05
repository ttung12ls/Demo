package com.example.demo.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    @Column(name = "username")
    private String username;
    @Column (name = "password")
    private String password;
    @Column (name = "email")
    private String email;
    @Column (name = "role")
    private String role;
    @Column (name = "created_at")
    @CreationTimestamp
    private LocalDate created_at;
    @Column (name = "updated_at")
    @UpdateTimestamp
    private LocalDate updated_at;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "users")
    private List<Posts> posts;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<Comments> comments;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }
}
