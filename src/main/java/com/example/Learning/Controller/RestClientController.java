package com.example.Learning.Controller;

import com.example.Learning.DTO.PostDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/restClientPosts")
public class RestClientController {
    private final RestClient restClient;

    public RestClientController(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable Long id) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        return restClient.get()
                .uri(url)
                .retrieve()
                .body(PostDTO.class);
    }
}
