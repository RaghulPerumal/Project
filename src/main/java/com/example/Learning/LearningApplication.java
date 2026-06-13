package com.example.Learning;

import com.example.Learning.Controller.PostController;
import com.example.Learning.Controller.RestClientController;
import com.example.Learning.Controller.RestTemplateController;
import com.example.Learning.Model.Major;
import com.example.Learning.Model.Student;
import com.example.Learning.Repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDate;

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
    private PostController postController;
    @Autowired
    private RestTemplateController restTemplateController;
    @Autowired
    private RestClientController restClientController;

    @Override
    public void run(String... args) {

        LOGGER.info("Student id 2 -> {}", repository.findById(2L).orElseGet(() -> new Student("Default", "Default Email")));

        LOGGER.info("Inserting new Student-> {}", repository.save(new Student("John", "A1234657")));

        LOGGER.info("Update Student 3 -> {}", repository.save(new Student(3L, "Victoria", "victoria.watson@example.com",
                LocalDate.of(2000, 1, 1), new Major(3L, "new major", 4, "desc"), 5.5)));

        repository.deleteById(2L);

        LOGGER.info("All users -> {}", repository.findAll());

        LOGGER.info("FeignClient -> {}",postController.getPostById(2L));

        LOGGER.info("RestTemplate -> {}",restTemplateController.getPostById(2L));

        LOGGER.info("RestClient -> {}",restClientController.getPostById(3L));
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
