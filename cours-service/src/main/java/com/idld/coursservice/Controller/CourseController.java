package com.idld.coursservice.Controller;

import com.idld.coursservice.DTO.CourseRequestDTO;
import com.idld.coursservice.DTO.CourseResponseDTO;
import com.idld.coursservice.Service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{courseId}/details")
    public CourseResponseDTO getCourseDetails(@PathVariable long courseId) {
        return courseService.getCourseDetails(courseId);
    }


    @GetMapping
    public List<CourseResponseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }



    @GetMapping("/{id}")
    public CourseResponseDTO getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public CourseResponseDTO createCourse(@RequestBody CourseRequestDTO courseRequestDTO) {
        return courseService.createCourse(courseRequestDTO);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable Long id, @RequestBody CourseRequestDTO courseRequestDTO) {
        courseService.updateCourse(id, courseRequestDTO);
    }

    @DeleteMapping("/{id}")
    public CourseResponseDTO deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }



}
