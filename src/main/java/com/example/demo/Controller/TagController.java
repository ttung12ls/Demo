package com.example.demo.Controller;

import com.example.demo.Entity.Tags;
import com.example.demo.dto.request.TagCreationRequest;
import com.example.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping
    Tags createTag(@RequestBody TagCreationRequest request) {
        return tagService.createTag(request);
    }
    @GetMapping
    List<Tags> getAllTags() {
        return tagService.getAllTags();
    }
    @GetMapping("/{tagId}")
    Tags getTagById(@PathVariable("tagId") Integer tagId) {
        return tagService.getTag(tagId);
    }

    @DeleteMapping("/{tagId}")
    String deleteTag(@PathVariable("tagId") Integer tagId) {
        tagService.deleteTag(tagId);
        return "Tag deleted";
    }
}
