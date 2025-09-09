package com.example.Learning.Utility;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ExecutorServiceManager {
    private final ExecutorService executorService;

    public ExecutorServiceManager(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @PreDestroy
    public void shutDownExecutor() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.MILLISECONDS)) {
                executorService.shutdown();
            }
        } catch (InterruptedException e) {
            executorService.shutdown();
            Thread.currentThread().interrupt();
        }
    }
}
