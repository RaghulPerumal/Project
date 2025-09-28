package com.example.Learning.Controller;

import com.example.Learning.DTO.PostDTO;
import com.example.Learning.Service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * FeignClient and resilience4j integration.
 */
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable Long id) {
        return service.getPostById(id);
    }

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return service.getAllPosts();
    }
}
