package com.idld.etudiantservice;

import com.idld.etudiantservice.model.Student;
import com.idld.etudiantservice.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EtudiantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(StudentRepository studentRepository)
    {
        return args-> {
            Student s1 = Student.builder()
                    .address("zezezeze")
                    .email("aze@gmail.com")
                    .phone("0623232323")
                    .firstName("Alex")
                    .lastName("Gates")
                    .build() ;

            studentRepository.save(s1) ;

            Student s2 = Student.builder()
                    .address("zezezeze")
                    .email("aze@gmail.com")
                    .phone("0623232323")
                    .firstName("Alex")
                    .lastName("Gates")
                    .build() ;

            studentRepository.save(s2) ;

        } ;
    }

}
