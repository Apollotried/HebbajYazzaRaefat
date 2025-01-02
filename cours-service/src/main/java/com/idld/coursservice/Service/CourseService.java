package com.idld.coursservice.Service;

import com.idld.coursservice.Entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course createCourse(Course course);
    Course updateCourse(Long id, Course course);
    Course deleteCourse(Long id);
}
