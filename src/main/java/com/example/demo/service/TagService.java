package com.example.demo.service;

import com.example.demo.Entity.Tags;
import com.example.demo.dto.request.TagCreationRequest;
import com.example.demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;
    public Tags createTag(TagCreationRequest request){
        Tags tag = new Tags();
        tag.setName(request.getName());

        return tagRepository.save(tag);
    }
    public List<Tags> getAllTags() {
        return tagRepository.findAll();
    }
    public Tags getTag(Integer tagId) {
        return tagRepository.findById(tagId).orElseThrow(() -> new RuntimeException("Tag not found"));
    }
public void deleteTag(Integer tagId) {
        tagRepository.deleteById(tagId);
}
}
