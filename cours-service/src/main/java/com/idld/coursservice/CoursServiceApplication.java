package com.idld.coursservice;

import com.idld.coursservice.Entity.Course;
import com.idld.coursservice.Repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class CoursServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CourseRepository courseRepository)
    {
        return args-> {
            Course c1 = Course.builder()
                    .credit(12)
                    .description("ezeze")
                    .title("cours1")
                    .TeacherId(1)
                    .build() ;

            courseRepository.save(c1);
        } ;
    }
}
