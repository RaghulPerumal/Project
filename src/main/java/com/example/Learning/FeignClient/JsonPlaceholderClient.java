package com.example.Learning.FeignClient;

import com.example.Learning.DTO.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "jsonPlaceholderClient", url = "https://jsonplaceholder.typicode.com")
public interface JsonPlaceholderClient {

    @GetMapping("/posts/{id}")
    PostDTO getPostById(@PathVariable("id") Long id);

    @GetMapping("/posts")
    List<PostDTO> getAllPosts();
}
