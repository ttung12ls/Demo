package com.example.demo.service;

import com.example.demo.Entity.Comments;
import com.example.demo.Entity.Posts;
import com.example.demo.Entity.Users;
import com.example.demo.dto.request.CommentCreationRequest;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    public Comments createComment(CommentCreationRequest request) {
        Comments comment = new Comments();
        comment.setContent(request.getContent());
        int post_id = request.getPost_id();
        Posts posts = null;
        Optional<Posts> postsopt = postRepository.findById(post_id);
        if (postsopt.isPresent()) {
            posts = postsopt.get();
        }
        comment.setPosts(posts);
        int user_id = request.getUser_id();
        Users users = null;
        Optional<Users> usersopt = userRepository.findById(user_id);
        if (usersopt.isPresent()) {
            users = usersopt.get();
        }
        comment.setUsers(users);
        comment.setContent(request.getContent());
        comment.setCreated_at(request.getCreated_at());
        return commentRepository.save(comment);
    }
    public List<Comments> getAllComments() {
        return commentRepository.findAll();
    }
    public Comments getComment(Integer commentId) {
        return commentRepository.findById(commentId).get();
    }
    public void deleteComment(Integer commentId) {
        commentRepository.deleteById(commentId);
    }
}
