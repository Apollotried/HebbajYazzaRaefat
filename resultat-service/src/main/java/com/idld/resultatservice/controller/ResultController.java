package com.idld.resultatservice.controller;

import com.idld.resultatservice.Dtos.CourseDto;
import com.idld.resultatservice.Dtos.ResultDTORequest;
import com.idld.resultatservice.Dtos.ResultDto;
import com.idld.resultatservice.Dtos.StudentDto;
import com.idld.resultatservice.entities.Result;
import com.idld.resultatservice.repository.ResultRepository;
import com.idld.resultatservice.service.ResultServiceInterf;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results") // Base URL for all endpoints in this controller
public class ResultController {

    private final ResultServiceInterf resultService;


    // Constructor Injection
    public ResultController(ResultServiceInterf resultService) {
        this.resultService = resultService;
    }

    //testing the communication
    @GetMapping("/student-info/{studentId}")
    public ResponseEntity<StudentDto> getStudentInfo(@PathVariable long studentId) {
        StudentDto student = resultService.getStudentById(studentId);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/course-info/{courseId}")
    public ResponseEntity<CourseDto> getCoursetInfo(@PathVariable long courseId) {
        CourseDto course = resultService.getCourseById(courseId);
        return ResponseEntity.ok(course);
    }


    // Create a new result
    @PostMapping
    public ResponseEntity<Result> createResult(@RequestBody ResultDTORequest resultDto) {
        Result result = resultService.createResult(resultDto);
        return ResponseEntity.ok(result); // Respond with HTTP 200 and the created result
    }

    // Get results by student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ResultDto>> getResultsByStudent(@PathVariable long studentId) {
        List<ResultDto> results = resultService.getResultByStudent(studentId);
        return ResponseEntity.ok(results);
    }

    // Get results by course ID
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<ResultDto>> getResultsByCourse(@PathVariable long courseId) {
        List<ResultDto> results = resultService.getResultByCourse(courseId);
        return ResponseEntity.ok(results);
    }

    //student infos and grade by courseId
    @GetMapping("/course/{courseId}/students-grades")
    public List<ResultDto> getStudentsWithGradesByCourse(@PathVariable long courseId){
        return resultService.getStudentsWithGradesByCourse(courseId);
    }


    // Update a result
    @PutMapping("/{resultId}")
    public ResponseEntity<Result> updateResult(@PathVariable long resultId, @RequestBody ResultDto resultDto) {
        Result updatedResult = resultService.updateResult(resultId, resultDto);
        return ResponseEntity.ok(updatedResult);
    }

    // Delete a result
    @DeleteMapping("/{resultId}")
    public ResponseEntity<Void> deleteResult(@PathVariable long resultId) {
        resultService.deleteResult(resultId);
        return ResponseEntity.noContent().build(); // Respond with HTTP 204 (No Content)
    }


    @PostMapping("/batch")
    public ResponseEntity<String> applyBatchGrades(@RequestBody List<ResultDTORequest> results) {
        try {
            resultService.applyBatchGrades(results);
            return ResponseEntity.ok("Batch grades applied successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error applying batch grades: " + e.getMessage());
        }
    }


}
