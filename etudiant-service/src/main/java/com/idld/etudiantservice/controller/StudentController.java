package com.idld.etudiantservice.controller;

import com.idld.etudiantservice.Dtos.StudentDtoRequest;
import com.idld.etudiantservice.Dtos.StudentDtoResponse;
import com.idld.etudiantservice.model.Student;
import com.idld.etudiantservice.service.StudentServiceInter;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    StudentServiceInter studentServiceInter;

    public StudentController(StudentServiceInter studentServiceInter) {
        this.studentServiceInter = studentServiceInter;
    }


    @GetMapping("/students")
    public List<StudentDtoResponse> getStudents() {
        return studentServiceInter.getAllStudents();
    }
    @GetMapping("/students/{id}")
    public StudentDtoResponse getStudentById(@PathVariable long id) {
        return studentServiceInter.getStudentById(id);
    }

    @PostMapping("/students")
    public void create(@RequestBody @Valid StudentDtoRequest student) {
        studentServiceInter.addStudent(student);
    }

    @PutMapping("/students/{id}")
    public void update(@PathVariable long id, @RequestBody StudentDtoRequest student) {
        studentServiceInter.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public void delete(@PathVariable long id) {
        studentServiceInter.deleteStudent(id);
    }

    @RequestMapping("/test")
    public String test() {
        return "Controller is working!";
    }


}
