package com.idld.coursservice.Service;

import com.idld.coursservice.Controller.TeacherClient;
import com.idld.coursservice.DTO.CourseRequestDTO;
import com.idld.coursservice.DTO.CourseResponseDTO;
import com.idld.coursservice.DTO.TeacherDtoResponse;
import com.idld.coursservice.Entity.Course;
import com.idld.coursservice.Mapper.CourseMapperInter;
import com.idld.coursservice.Repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapperInter courseMapper;
    private final TeacherClient teacherClient;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapperInter courseMapper, TeacherClient teacherClient) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.teacherClient = teacherClient;
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseResponseDTO> courseResponseDTOs = new ArrayList<>();

        for (Course course : courses) {
            courseResponseDTOs.add(courseMapper.toCourseDTO(course));
        }

        return courseResponseDTOs;
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id).get();
        return courseMapper.toCourseDTO(course);
    }

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        Course course = courseMapper.toCourse(courseRequestDTO);
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toCourseDTO(savedCourse);
    }

    @Override
    public void updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        // Retrieve the existing course from the database
        Course existingCourse = courseRepository.findById(id).get();

        // Manually set the values from the DTO to the existing entity
        existingCourse.setTitle(courseRequestDTO.getTitle());
        existingCourse.setDescription(courseRequestDTO.getDescription());
        existingCourse.setCredit(courseRequestDTO.getCredit());
        existingCourse.setTeacherId(courseRequestDTO.getTeacherId());

        // Save the updated course entity
        courseRepository.save(existingCourse);
    }


    @Override
    public CourseResponseDTO deleteCourse(Long id) {
        Course course = courseRepository.findById(id).get();
        CourseResponseDTO courseResponseDTO = courseMapper.toCourseDTO(course);
        courseRepository.delete(course);
        return courseResponseDTO;
    }

    @Override
    public CourseResponseDTO getCourseDetails(long courseId) {
        // Fetch course details from your repository or service
        CourseResponseDTO course = getCourseById(courseId);

        // Use Feign client to get teacher details
        TeacherDtoResponse teacher = teacherClient.getTeacherById(course.getTeacherId());
        course.setTeacher(teacher);

        return course;
    }

    @Override
    public long getTotalCoursesCount(){
        return courseRepository.count();
    }
}
