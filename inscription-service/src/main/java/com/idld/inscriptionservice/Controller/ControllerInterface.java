package com.idld.inscriptionservice.Controller;

import com.idld.inscriptionservice.DTOs.RequestInscriptionDTO;
import com.idld.inscriptionservice.DTOs.ResponseInscriptionDTO;
import com.idld.inscriptionservice.Service.InscriptionServiceInterface;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ControllerInterface {
    public ResponseInscriptionDTO inscrireEtudiant(@RequestBody RequestInscriptionDTO requestInscriptionDTO) ;
    public List<ResponseInscriptionDTO> getAllInscriptions();

}