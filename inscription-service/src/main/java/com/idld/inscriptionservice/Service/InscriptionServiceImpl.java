package com.idld.inscriptionservice.Service;

import com.idld.inscriptionservice.DTOs.RequestInscriptionDTO;
import com.idld.inscriptionservice.DTOs.ResponseInscriptionDTO;
import com.idld.inscriptionservice.Entity.Inscription;
import com.idld.inscriptionservice.Mapper.InscriptionMapperInterface;
import com.idld.inscriptionservice.Model.Course;
import com.idld.inscriptionservice.Model.Student;
import com.idld.inscriptionservice.Repository.InscriptionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InscriptionServiceImpl implements InscriptionServiceInterface {

    private final InscriptionRepository inscriptionRepository;
    private final StudentFeignClient studentFeignClient;
    private final CourseFeignClient courseFeignClient;
    private final InscriptionMapperInterface inscriptionMapperInterface;

    public InscriptionServiceImpl(InscriptionRepository inscriptionRepository,
                                  StudentFeignClient studentFeignClient,
                                  CourseFeignClient courseFeignClient,
                                  InscriptionMapperInterface inscriptionMapperInterface) {
        this.inscriptionRepository = inscriptionRepository;
        this.studentFeignClient = studentFeignClient;
        this.courseFeignClient = courseFeignClient;
        this.inscriptionMapperInterface=inscriptionMapperInterface;
    }

    @Override
    public ResponseInscriptionDTO inscrireEtudiant(RequestInscriptionDTO requestInscriptionDTO) {
        Student student = studentFeignClient.getStudentById(requestInscriptionDTO.getStudentId());
        if (student == null) {
            throw new RuntimeException("Student with ID " + requestInscriptionDTO.getStudentId() + " does not exist.");
        }
        Course course = courseFeignClient.getCourseById(requestInscriptionDTO.getCourseId());
        if (course == null) {
            throw new RuntimeException("Course with ID " + requestInscriptionDTO.getCourseId() + " does not exist.");
        }
        Inscription inscription = inscriptionMapperInterface.toEntity(requestInscriptionDTO);
        inscription.setDateInscription(LocalDate.now().toString());
        inscription = inscriptionRepository.save(inscription);
        return inscriptionMapperInterface.toDto(inscription);
    }


    @Override
    public List<ResponseInscriptionDTO> getAllInscriptions() {
        List<ResponseInscriptionDTO> responseList = new ArrayList<>();
        List<Inscription> inscriptions = inscriptionRepository.findAll();
        for (Inscription inscription : inscriptions) {
            ResponseInscriptionDTO responseDTO = new ResponseInscriptionDTO();
            BeanUtils.copyProperties(inscription, responseDTO);
            responseList.add(responseDTO);
        }

        return responseList;
    }

}