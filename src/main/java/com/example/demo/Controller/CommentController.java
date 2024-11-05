package com.example.demo.Controller;

import com.example.demo.Entity.Comments;
import com.example.demo.dto.request.CommentCreationRequest;
import com.example.demo.service.CommentService;
import jakarta.persistence.Index;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    Comments createComment(@RequestBody CommentCreationRequest request) {
        return commentService.createComment(request);
    }

    @GetMapping
    List<Comments> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{commentId}")
    Comments getCommentById(@PathVariable("commentId") Integer commentId) {
        return commentService.getComment(commentId);
    }

    @DeleteMapping("/{commentId}")
    String deleteComment(@PathVariable("commentId") Integer commentId) {
        commentService.deleteComment(commentId);
        return "Comment deleted";
    }
}