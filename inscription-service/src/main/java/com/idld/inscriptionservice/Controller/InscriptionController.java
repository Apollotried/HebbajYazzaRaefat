package com.idld.inscriptionservice.Controller;


import com.idld.inscriptionservice.DTOs.RequestInscriptionDTO;
import com.idld.inscriptionservice.DTOs.ResponseInscriptionDTO;
import com.idld.inscriptionservice.Service.InscriptionServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionController implements ControllerInterface{
    private final InscriptionServiceInterface inscriptionService;

    public InscriptionController(InscriptionServiceInterface inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @Override
    @PostMapping
    public ResponseInscriptionDTO inscrireEtudiant(@RequestBody RequestInscriptionDTO requestInscriptionDTO) {
        return inscriptionService.inscrireEtudiant(requestInscriptionDTO);
    }

    @Override
    @GetMapping
    public List<ResponseInscriptionDTO> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }
}