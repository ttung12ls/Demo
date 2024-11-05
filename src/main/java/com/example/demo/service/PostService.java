package com.example.demo.service;

import com.example.demo.Entity.Categories;
import com.example.demo.Entity.Posts;
import com.example.demo.Entity.Users;
import com.example.demo.dto.request.PostCreationRequest;
import com.example.demo.dto.request.PostUpdateRequest;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.dto.request.CategoryCreationRequest;
import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    public Posts createPost(PostCreationRequest request) {
        Posts post = new Posts();
        int category_id = request.getCategory_id();
        Categories categories = null;
        Optional<Categories> categoriesOpt = categoryRepository.findById(category_id);
        if (categoriesOpt.isPresent()) {
            categories = categoriesOpt.get();
        }
        post.setCategories(categories);
        int user_id = request.getAuthor_id();
        Users author = null;
        Optional<Users> authorOpt = userRepository.findById(user_id);
        if (authorOpt.isPresent()) {
            author = authorOpt.get();
        }
        post.setUsers(author);
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setStatus(request.getStatus());
        post.setCreated_at(request.getCreated_at());
        post.setUpdated_at(request.getUpdated_at());
        return postRepository.save(post);
    }
    public Posts updatePost(Integer postId, PostUpdateRequest request) {
        Posts post = getPost(postId);
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setStatus(request.getStatus());
        return postRepository.save(post);
    }
    public List<Posts> getAllPosts() {
        return postRepository.findAll();
    }
    public Posts getPost(Integer postId) {
        return postRepository.findById(postId).get();
    }
    public void deletePost(Integer postId) {
        postRepository.deleteById(postId);
    }

}
