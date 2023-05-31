package com.example.demo.gestionSurveillance.emploi.dto.mapper;

import com.example.demo.Doa.EnseignantRepository;
import com.example.demo.gestionSurveillance.emploi.dto.EmploiDTORequest;
import com.example.demo.gestionSurveillance.emploi.dto.EmploiDTOResponse;
import com.example.demo.entities.Emploi;
import com.example.demo.entities.Enseignant;
import jakarta.persistence.EntityNotFoundException;

public class EmploiMappers {

    public static EmploiDTOResponse mapEmploiToDTOResponse(Emploi emploi) {
        return new EmploiDTOResponse(
                emploi.getDateDebut(),
                emploi.getDateFin()


        );
    }

    public static Emploi mapEmploiToDTORequest(EmploiDTORequest emploiRequest, EnseignantRepository enseignantRepository) {
        Enseignant enseignant = enseignantRepository.findById(emploiRequest.enseignant())
                .orElseThrow(() -> new EntityNotFoundException("Employe not found"));

        return new Emploi(
                emploiRequest.dateDebut(),
                emploiRequest.dateFin(),
                enseignant

        );
    }
}
