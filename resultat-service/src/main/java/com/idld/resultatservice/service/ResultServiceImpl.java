package com.idld.resultatservice.service;

import com.idld.resultatservice.Dtos.CourseDto;
import com.idld.resultatservice.Dtos.ResultDto;
import com.idld.resultatservice.Dtos.StudentDto;
import com.idld.resultatservice.controller.CourseClient;
import com.idld.resultatservice.controller.StudentClient;
import com.idld.resultatservice.entities.Result;
import com.idld.resultatservice.exceptions.EntityNotFoundException;
import com.idld.resultatservice.mapper.ResultMapperInterf;
import com.idld.resultatservice.repository.ResultRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultServiceImpl implements ResultServiceInterf{

    ResultRepository resultRepository;
    CourseClient courseClient;
    StudentClient studentClient;
    ResultMapperInterf resultMapperInterf;

    public ResultServiceImpl(ResultRepository resultRepository, StudentClient studentClient, CourseClient courseClient, ResultMapperInterf resultMapperInterf) {
        this.resultRepository = resultRepository;
        this.courseClient = courseClient;
        this.studentClient = studentClient;
        this.resultMapperInterf = resultMapperInterf;
    }



    @Override
    public Result createResult(ResultDto resultDto) {
        StudentDto student = studentClient.getStudentById(resultDto.getStudentId());
        CourseDto course = courseClient.getCourseById(resultDto.getCourseId());

        if (student == null || course == null) {
            throw new EntityNotFoundException("Student or Course not found");
        }

        Result result = resultMapperInterf.resultDtoToResult(resultDto);

        return resultRepository.save(result);
    }


    @Override
    public List<ResultDto> getResultByStudent(long studentId) {

        List<Result> results = resultRepository.findByStudentId(studentId);
        List<ResultDto> resultsDto = new ArrayList<>();
        for (Result result : results) {
            resultsDto.add(resultMapperInterf.resultToResultDto(result));
        }
        return resultsDto;

    }

    @Override
    public List<ResultDto> getResultByCourse(long courseId) {

        List<Result> results = resultRepository.findByCourseId(courseId);

        List<ResultDto> resultsDto = new ArrayList<>();
        for (Result result : results) {
            resultsDto.add(resultMapperInterf.resultToResultDto(result));
        }
        return resultsDto;
    }

    @Override
    public Result updateResult(long resultId, ResultDto resultDto) {
        // Fetch the result by its ID
        Optional<Result> resultOptional = resultRepository.findById(resultId);

        if (resultOptional.isPresent()) {
            Result result = resultOptional.get();
            result.setGrade(resultDto.getGrade()); // Update grade from DTO
            result.setSemester(resultDto.getSemester()); // Update semester from DTO
            return resultRepository.save(result);  // Save the updated result
        } else {
            throw new IllegalArgumentException("Result not found");
        }
    }


    @Override
    public void deleteResult(long resultId) {
        resultRepository.deleteById(resultId);

    }

    @Override
    public StudentDto getStudentById(long studentId) {
        return studentClient.getStudentById(studentId);
    }
    @Override
    public CourseDto getCourseById(long courseId) {
        return courseClient.getCourseById(courseId);
    }
}
