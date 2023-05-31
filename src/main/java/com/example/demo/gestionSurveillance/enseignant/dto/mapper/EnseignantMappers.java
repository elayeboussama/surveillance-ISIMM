package com.example.demo.gestionSurveillance.enseignant.dto.mapper;

import com.example.demo.Doa.DepartementRepository;
import com.example.demo.gestionSurveillance.enseignant.dto.EnseignantDTORequest;
import com.example.demo.gestionSurveillance.enseignant.dto.EnseignantDTOResponse;
import com.example.demo.entities.Department;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.enums.Grade;
import com.example.demo.entities.enums.Sexe;
import jakarta.persistence.EntityNotFoundException;

public class EnseignantMappers {



    public static EnseignantDTOResponse mapEnseignantToDTOResponse(Enseignant enseignant) {
        return new EnseignantDTOResponse(
                enseignant.getId(),
                enseignant.getDepartment(),
                enseignant.getCin(),
                enseignant.getNom(),
                enseignant.getPrenom(),
                enseignant.getNaissance(),
                enseignant.getSexe(),
                enseignant.getAdresse(),
//                enseignant.getPassword(),
                enseignant.getEmail(),
                enseignant.getTelephone(),
                enseignant.getAge(),
                enseignant.getDateEmbauche(),
                enseignant.getNbJourCongeTotale(),
                enseignant.getNbJourCongeRestant(),
                enseignant.getSalaire(),
                enseignant.getNombreHeures(),
                enseignant.getGradeEnseignant()

        );
    }

    public static Enseignant mapEnseignantToDTORequest(EnseignantDTORequest enseignantRequest, DepartementRepository departementRepository) {



        Department department = departementRepository.findById(enseignantRequest.department())
                .orElseThrow(() -> new EntityNotFoundException("Employe not found"));

        return new Enseignant(
                department,
                enseignantRequest.cin(),
                enseignantRequest.nom(),
                enseignantRequest.prenom(),
                enseignantRequest.naissance(),
                Sexe.valueOf(enseignantRequest.sexe().toString()),
                enseignantRequest.adresse(),
                enseignantRequest.password(),
                enseignantRequest.email(),
                enseignantRequest.telephone(),
                enseignantRequest.age(),
                enseignantRequest.DateEmbauche(),
                enseignantRequest.NbJourCongeTotale(),
                enseignantRequest.NbJourCongeRestant(),
                enseignantRequest.Salaire(),
                enseignantRequest.nombreHeures(),
                Grade.valueOf(enseignantRequest.gradeEnseignant().toString())


                );
    }
}
