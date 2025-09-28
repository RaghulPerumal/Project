package com.example.Learning.Controller;

import com.example.Learning.DTO.PostDTO;
import com.example.Learning.FeignClient.JsonPlaceholderClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final JsonPlaceholderClient client;

    public PostController(final JsonPlaceholderClient client) {
        this.client = client;
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable Long id) {
        return client.getPostById(id);
    }

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return client.getAllPosts();
    }
}
