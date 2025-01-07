package com.idld.resultatservice.mapper;

import com.idld.resultatservice.Dtos.ResultDto;
import com.idld.resultatservice.entities.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ResultMapperImplTest {
    private final ResultMapperImpl resultMapper = new ResultMapperImpl();


    @Test
    void testToResult_ShouldMapCorrectly() {
        ResultDto resultDto = new ResultDto();
        resultDto.setCourseId(1L);
        resultDto.setStudentId(2L);
        resultDto.setGrade(10);
        resultDto.setSemester(1);

        Result result = resultMapper.resultDtoToResult(resultDto);

        assertNotNull(result);
        assertEquals(result.getStudentId(), resultDto.getStudentId());
        assertEquals(result.getCourseId(), resultDto.getCourseId());
        assertEquals(result.getGrade(), resultDto.getGrade());
        assertEquals(result.getSemester(), resultDto.getSemester());

    }

    @Test
    void testToResult_NullInput_ShouldReturnNull() {
        Result result = resultMapper.resultDtoToResult(null);
        assertNull(result);

    }

    @Test
    void testToResultDto_ShouldMapCorrectly() {
        Result result = new Result();
        result.setStudentId(2L);
        result.setCourseId(3L);
        result.setGrade(4);
        result.setSemester(5);

        ResultDto resultDto = resultMapper.resultToResultDto(result);

        assertNotNull(resultDto);
        assertEquals(result.getStudentId(), resultDto.getStudentId());
        assertEquals(result.getCourseId(), resultDto.getCourseId());
        assertEquals(result.getGrade(), resultDto.getGrade());
        assertEquals(result.getSemester(), resultDto.getSemester());

    }

    @Test
    void testToResultDto_NullInput_ShouldReturnNull() {
        ResultDto resultDto = resultMapper.resultToResultDto(null);

        assertNull(resultDto);
    }

}