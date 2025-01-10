package com.idld.inscriptionservice.Service;

import com.idld.inscriptionservice.DTOs.RequestInscriptionDTO;
import com.idld.inscriptionservice.DTOs.ResponseInscriptionDTO;

import java.util.List;

public interface InscriptionServiceInterface {
    ResponseInscriptionDTO inscrireEtudiant(RequestInscriptionDTO requestInscriptionDTO);
    List<ResponseInscriptionDTO> getAllInscriptions();
}