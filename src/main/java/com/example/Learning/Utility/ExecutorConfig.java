package com.example.Learning.Utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class ExecutorConfig {
    @Bean(destroyMethod = "")
    public ExecutorService taskExecutor() {

        return Executors.newVirtualThreadPerTaskExecutor();

//        return new ThreadPoolExecutor(1, 16, 0L, TimeUnit.MILLISECONDS,
//                new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}