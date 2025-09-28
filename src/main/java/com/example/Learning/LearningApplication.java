package com.example.Learning;

import com.example.Learning.Controller.PostController;
import com.example.Learning.Controller.StudentController;
import com.example.Learning.Model.Major;
import com.example.Learning.Model.Student;
import com.example.Learning.Repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;

@EnableFeignClients
@SpringBootApplication
public class LearningApplication implements CommandLineRunner {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(LearningApplication.class, args);
    }

    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentController studentController;

    @Autowired
    private PostController postController;

    @Override
    public void run(String... args) {

        LOGGER.info("Student id 10001 -> {}", repository.findById(10001L));

        LOGGER.info("Inserting -> {}", repository.save(new Student("John", "A1234657")));

        LOGGER.info("Update 10003 -> {}", repository.save(new Student(1L, "Victoria", "victoria.watson@example.com",
                LocalDate.of(2000, 1, 1), new Major(3L, "new major", 4, "desc"), 5.5)));

        repository.deleteById(2L);

        LOGGER.info("All users -> {}", repository.findAll());

        System.out.println(postController.getPostById(1L));

    }

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//		};
//	}
}
