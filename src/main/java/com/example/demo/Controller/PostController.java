package com.example.demo.Controller;

import com.example.demo.Entity.Posts;
import com.example.demo.dto.request.PostCreationRequest;
import com.example.demo.dto.request.PostUpdateRequest;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping
    Posts createPost(@RequestBody PostCreationRequest request) {
        return postService.createPost(request);
    }
    @GetMapping
    List<Posts> getAllPosts() {
        return postService.getAllPosts();
    }
    @GetMapping("/{postId}")
    Posts getPostById(@PathVariable("postId") Integer postId) {
        return postService.getPost(postId);
    }
@PutMapping("/{postId}")
    Posts updatePost(@PathVariable Integer postId, @RequestBody PostUpdateRequest request) {
        return postService.updatePost(postId, request);
}
@DeleteMapping("/{postId}")
    String deletePost(@PathVariable("userId") Integer postId) {
        postService.deletePost(postId);
        return "Deleted post";
}
}
