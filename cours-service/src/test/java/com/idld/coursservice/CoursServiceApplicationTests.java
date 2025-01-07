package com.idld.coursservice;



import com.idld.coursservice.DTO.CourseRequestDTO;
import com.idld.coursservice.DTO.CourseResponseDTO;
import com.idld.coursservice.Entity.Course;
import com.idld.coursservice.Mapper.CourseMapperInter;
import com.idld.coursservice.Repository.CourseRepository;
import com.idld.coursservice.Service.CourseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private CourseMapperInter courseMapper;

    @InjectMocks
    private CourseServiceImpl courseService;

    private CourseRequestDTO courseRequestDTO;
    private Course course;
    private CourseResponseDTO courseResponseDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        courseRequestDTO = new CourseRequestDTO(1L, "Course Title", "Course Description", 3, "Instructor");
        course = new Course(1L, "Course Title", "Course Description", 3, "Instructor");
        courseResponseDTO = new CourseResponseDTO("Course Title", "Course Description", 3, "Instructor");
    }

    @Test
    void testCreateCourse() {
        when(courseMapper.toCourse(courseRequestDTO)).thenReturn(course);
        when(courseRepository.save(course)).thenReturn(course);
        when(courseMapper.toCourseDTO(course)).thenReturn(courseResponseDTO);

        CourseResponseDTO createdCourse = courseService.createCourse(courseRequestDTO);

        assertNotNull(createdCourse);
        assertEquals("Course Title", createdCourse.getTitle());
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    void testGetCourseById() {
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(courseMapper.toCourseDTO(course)).thenReturn(courseResponseDTO);

        CourseResponseDTO fetchedCourse = courseService.getCourseById(1L);

        assertNotNull(fetchedCourse);
        assertEquals("Course Title", fetchedCourse.getTitle());
        verify(courseRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteCourse() {
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(courseMapper.toCourseDTO(course)).thenReturn(courseResponseDTO);

        CourseResponseDTO deletedCourse = courseService.deleteCourse(1L);

        assertNotNull(deletedCourse);
        assertEquals("Course Title", deletedCourse.getTitle());
        verify(courseRepository, times(1)).delete(course);
    }

    @Test
    void testUpdateCourse() {
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        courseService.updateCourse(1L, courseRequestDTO);

        assertEquals("Course Title", course.getTitle());
        assertEquals("Course Description", course.getDescription());
        assertEquals(3, course.getCredit());
        assertEquals("Instructor", course.getInstructor());
        verify(courseRepository, times(1)).save(course);
    }
}
