package com.idld.coursservice.Service;


import com.idld.coursservice.DTO.CourseRequestDTO;
import com.idld.coursservice.DTO.CourseResponseDTO;

import java.util.List;

public interface CourseService {
    List<CourseResponseDTO> getAllCourses();
    CourseResponseDTO getCourseById(Long id);
    CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO);
    CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO);
    CourseResponseDTO deleteCourse(Long id);
}
