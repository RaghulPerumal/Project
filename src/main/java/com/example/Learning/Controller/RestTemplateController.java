package com.example.Learning.Controller;

import com.example.Learning.DTO.PostDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/restPosts")
public class RestTemplateController {
    private final RestTemplate restTemplate;

    public RestTemplateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable Long id) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        return restTemplate.getForObject(url, PostDTO.class);
    }

    @GetMapping
    public List<PostDTO> getAllPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        return restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<PostDTO>>() {}).getBody();
    }

}
