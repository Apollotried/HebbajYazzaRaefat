package com.idld.profservice;

import com.idld.profservice.model.Teacher;
import com.idld.profservice.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProfServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(TeacherRepository Repository)
    {
        return args-> {
            Teacher t1 = Teacher.builder()
                    .address("zezezeze")
                    .email("aze@gmail.com")
                    .phone("0623232323")
                    .firstName("PRO1")
                    .lastName("GaAAE")
                    .build() ;

            Repository.save(t1) ;


            Teacher t2 = Teacher.builder()
                    .address("zezezeze")
                    .email("aze@gmail.com")
                    .phone("0623232323")
                    .firstName("PRO2")
                    .lastName("uio")
                    .build() ;

            Repository.save(t1) ;




        } ;
    }

}
