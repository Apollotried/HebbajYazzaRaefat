package com.idld.coursservice.Service;

import com.idld.coursservice.DTO.CourseRequestDTO;
import com.idld.coursservice.DTO.CourseResponseDTO;
import com.idld.coursservice.Entity.Course;
import com.idld.coursservice.Repository.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseResponseDTO> courseResponseDTOs = new ArrayList<>();

        for (Course course : courses) {
            CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
            BeanUtils.copyProperties(course, courseResponseDTO);
            courseResponseDTOs.add(courseResponseDTO);
        }

        return courseResponseDTOs;
    }


    @Override
    public CourseResponseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id).get();
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        BeanUtils.copyProperties(course, courseResponseDTO);
        return courseResponseDTO;
    }


    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        Course course = new Course();
        BeanUtils.copyProperties(courseRequestDTO, course);
        Course savedCourse = courseRepository.save(course);
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        BeanUtils.copyProperties(savedCourse, courseResponseDTO);
        return courseResponseDTO;
    }


    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        Course existingCourse = courseRepository.findById(id).get();
        BeanUtils.copyProperties(courseRequestDTO, existingCourse, "id");
        Course updatedCourse = courseRepository.save(existingCourse);
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        BeanUtils.copyProperties(updatedCourse, courseResponseDTO);
        return courseResponseDTO;
    }


    @Override
    public CourseResponseDTO deleteCourse(Long id) {
        Course course = courseRepository.findById(id).get();
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        BeanUtils.copyProperties(course, courseResponseDTO);

        courseRepository.delete(course);
        return courseResponseDTO;
    }



}
