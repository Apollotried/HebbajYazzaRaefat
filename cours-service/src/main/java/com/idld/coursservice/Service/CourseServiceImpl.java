package com.idld.coursservice.Service;


import com.idld.coursservice.Entity.Course;
import com.idld.coursservice.Repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Course existingCourse = getCourseById(id);
        existingCourse.setTitle(course.getTitle());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setCredit(course.getCredit());
        existingCourse.setInstructor(course.getInstructor());
        return courseRepository.save(existingCourse);
    }

    @Override
    public Course deleteCourse(Long id) {
        Course course=courseRepository.findById(id).get();
        courseRepository.deleteById(id);
        return course;
    }
}


