package com.example.Learning.Service;

import com.example.Learning.DTO.PostDTO;
import com.example.Learning.FeignClient.JsonPlaceholderClient;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PostService {

    private final JsonPlaceholderClient client;

    public PostService(JsonPlaceholderClient client) {
        this.client = client;
    }

    @Retry(name = "jsonPlaceholderCircuitBreaker")
    @Bulkhead(name = "jsonPlaceholderCircuitBreaker", type = Bulkhead.Type.SEMAPHORE)
    @CircuitBreaker(name = "jsonPlaceholderCircuitBreaker", fallbackMethod = "fallbackGetPostById")
    public PostDTO getPostById(Long id) {
        return client.getPostById(id);
    }

    public PostDTO fallbackGetPostById(Long id, Throwable throwable) {
        // Return a default PostDTO or null or handle fallback
        return new PostDTO(); // or null or throw custom exception
    }

    @Retry(name = "jsonPlaceholderCircuitBreaker")
    @Bulkhead(name = "jsonPlaceholderCircuitBreaker", type = Bulkhead.Type.SEMAPHORE)
    @CircuitBreaker(name = "jsonPlaceholderCircuitBreaker", fallbackMethod = "fallbackGetAllPosts")
    public List<PostDTO> getAllPosts() {
        return client.getAllPosts();
    }

    public List<PostDTO> fallbackGetAllPosts(Throwable throwable) {
        // Return empty list or cached data or any default
        return Collections.emptyList();
    }
}
