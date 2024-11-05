package com.example.demo.Entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name = "comments")
public class Comments {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int comment_id;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name ="post_id")
    private Posts posts;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id")
    private Users users;
    @Column (name = "content")
    private String content;
    @Column (name = "created_at")
    @CreationTimestamp
    private LocalDateTime created_at;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
