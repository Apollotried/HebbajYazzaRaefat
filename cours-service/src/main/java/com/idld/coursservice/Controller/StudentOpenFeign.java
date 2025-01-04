package com.idld.coursservice.Controller;

import com.idld.coursservice.modele.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "etudiant-service", url = "http://localhost:8080/api")
public interface StudentFeignClient {

    @GetMapping("/students")
    List<Student> getAllStudents();

    @GetMapping("/students/{id}")
    Student getStudentById(@PathVariable Long id);

    @GetMapping("/students/course/{courseId}")
    List<Student> getStudentsByCourseId(@PathVariable Long courseId);
}
