package com.idld.inscriptionservice.Service;

import com.idld.inscriptionservice.DTOs.AssignCoursesRequestDTO;
import com.idld.inscriptionservice.DTOs.RequestInscriptionDTO;
import com.idld.inscriptionservice.DTOs.ResponseInscriptionDTO;
import com.idld.inscriptionservice.DTOs.courseDTO;
import com.idld.inscriptionservice.Model.Course;

import java.util.List;

public interface InscriptionServiceInterface {
    ResponseInscriptionDTO inscrireEtudiant(RequestInscriptionDTO requestInscriptionDTO);
    List<ResponseInscriptionDTO> getAllInscriptions();

    void assignCoursesToStudent(AssignCoursesRequestDTO assignCoursesRequestDTO);

    public List<courseDTO> getCoursesForStudent(Long studentId);
    public List<Long> findCourseIdsByStudentId(Long studentId);
}