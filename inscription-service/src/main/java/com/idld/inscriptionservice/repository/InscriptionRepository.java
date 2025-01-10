package com.idld.inscriptionservice.Repository;

import com.idld.inscriptionservice.Entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository  extends JpaRepository<Inscription, Long> {
}