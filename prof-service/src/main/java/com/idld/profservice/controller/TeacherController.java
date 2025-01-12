package com.idld.profservice.controller;

import com.idld.profservice.dtos.TeacherDtoRequest;
import com.idld.profservice.dtos.TeacherDtoResponse;
import com.idld.profservice.service.TeacherServiceInter;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {
    private final TeacherServiceInter teacherServiceInter;

    public TeacherController(TeacherServiceInter teacherServiceInter) {
        this.teacherServiceInter = teacherServiceInter;
    }

    @GetMapping("/teachers")
    public List<TeacherDtoResponse> getTeachers() {
        return teacherServiceInter.getAllTeachers();
    }

    @GetMapping("/teachers/{id}")
    public TeacherDtoResponse getTeacherById(@PathVariable long id) {
        return teacherServiceInter.getTeacherById(id);
    }

    @PostMapping("/teachers")
    public void create(@RequestBody @Valid TeacherDtoRequest teacherDtoRequest) {
        teacherServiceInter.addTeacher(teacherDtoRequest);
    }

    @PutMapping("/teachers/{id}")
    public void update(@PathVariable long id, @RequestBody TeacherDtoRequest teacherDtoRequest) {
        teacherServiceInter.updateTeacher(id, teacherDtoRequest);
    }

    @DeleteMapping("/teachers/{id}")
    public void delete(@PathVariable long id) {
        teacherServiceInter.deleteTeacher(id);
    }

    @RequestMapping("/test")
    public String test() {
        return "Controller is working!";
    }


    @GetMapping("/teachers/count")
    public long getTeachersCount(){
        return teacherServiceInter.getTotalTeachersCount();
    }
}
