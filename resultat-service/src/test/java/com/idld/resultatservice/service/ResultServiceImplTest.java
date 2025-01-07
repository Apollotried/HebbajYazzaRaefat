package com.idld.resultatservice.service;

import com.idld.resultatservice.Dtos.CourseDto;
import com.idld.resultatservice.Dtos.ResultDto;
import com.idld.resultatservice.Dtos.StudentDto;
import com.idld.resultatservice.controller.CourseClient;
import com.idld.resultatservice.controller.StudentClient;
import com.idld.resultatservice.entities.Result;
import com.idld.resultatservice.mapper.ResultMapperInterf;
import com.idld.resultatservice.repository.ResultRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

class ResultServiceImplTest {
    @Mock
    private ResultRepository resultRepository;

    @Mock
    private CourseClient courseClient;

    @Mock
    private StudentClient studentClient;

    @Mock
    private ResultMapperInterf resultMapperInterf;

    @InjectMocks
    private ResultServiceImpl resultService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateResult_ShouldSaveResult() {
        ResultDto resultDto = new ResultDto(1L, 2L, 10, 1);

        StudentDto studentDto = new StudentDto(1L, "John", "Doe", "aze", "zez", "ze");
        CourseDto courseDto = new CourseDto(2L, "Math", "aze", 10);

        Result result = new Result();

        when(studentClient.getStudentById(1L)).thenReturn(studentDto);
        when(courseClient.getCourseById(2L)).thenReturn(courseDto);
        when(resultMapperInterf.resultDtoToResult(resultDto)).thenReturn(result);
        when(resultRepository.save(result)).thenReturn(result);

        Result savedResult = resultService.createResult(resultDto);

        assertNotNull(savedResult);
        verify(studentClient, times(1)).getStudentById(1L);
        verify(courseClient, times(1)).getCourseById(2L);
        verify(resultRepository, times(1)).save(result);

    }
    @Test
    void testGetResultByStudent_ShouldReturnResults() {
        // Arrange
        long studentId = 2L;
        Result result = new Result();
        ResultDto resultDto = new ResultDto();
        when(resultRepository.findByStudentId(studentId)).thenReturn(Arrays.asList(result));
        when(resultMapperInterf.resultToResultDto(result)).thenReturn(resultDto);

        // Act
        List<ResultDto> results = resultService.getResultByStudent(studentId);

        // Assert
        assertNotNull(results);
        assertEquals(1, results.size());
        verify(resultRepository, times(1)).findByStudentId(studentId);
    }

    @Test
    void testGetResultByCourse_ShouldReturnResults() {
        // Arrange
        long courseId = 1L;
        Result result = new Result();
        ResultDto resultDto = new ResultDto();
        when(resultRepository.findByCourseId(courseId)).thenReturn(Arrays.asList(result));
        when(resultMapperInterf.resultToResultDto(result)).thenReturn(resultDto);

        // Act
        List<ResultDto> results = resultService.getResultByCourse(courseId);

        // Assert
        assertNotNull(results);
        assertEquals(1, results.size());
        verify(resultRepository, times(1)).findByCourseId(courseId);
    }

    @Test
    void testUpdateResult_ShouldUpdateAndSaveResult() {
        // Arrange
        long resultId = 1L;
        Result existingResult = new Result();
        ResultDto resultDto = new ResultDto(1L, 2L, 15, 2);
        when(resultRepository.findById(resultId)).thenReturn(Optional.of(existingResult));
        when(resultRepository.save(existingResult)).thenReturn(existingResult);

        // Act
        Result updatedResult = resultService.updateResult(resultId, resultDto);

        // Assert
        assertNotNull(updatedResult);
        assertEquals(15, existingResult.getGrade());
        assertEquals(2, existingResult.getSemester());
        verify(resultRepository, times(1)).findById(resultId);
        verify(resultRepository, times(1)).save(existingResult);
    }

    @Test
    void testUpdateResult_ShouldThrowException_WhenResultNotFound() {
        // Arrange
        long resultId = 1L;
        ResultDto resultDto = new ResultDto();

        when(resultRepository.findById(resultId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> resultService.updateResult(resultId, resultDto));
        verify(resultRepository, times(1)).findById(resultId);
        verify(resultRepository, never()).save(any(Result.class));
    }

    @Test
    void testDeleteResult_ShouldDeleteResult() {
        // Arrange
        long resultId = 1L;

        // Act
        resultService.deleteResult(resultId);

        // Assert
        verify(resultRepository, times(1)).deleteById(resultId);
    }

}