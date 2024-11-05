package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class PostTags {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int post_tag_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "post_id")
    private Posts posts;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "tag_id")
    private Tags tags;

    public int getPost_tag_id() {
        return post_tag_id;
    }

    public void setPost_tag_id(int post_tag_id) {
        this.post_tag_id = post_tag_id;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }
}
