package com.example.demo.controllersTest.enseignant.dto.mapper;

import com.example.demo.controllersTest.enseignant.dto.EnseignantDTORequest;
import com.example.demo.controllersTest.enseignant.dto.EnseignantDTOResponse;
import com.example.demo.entities.Enseignant;

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

    public static Enseignant mapEnseignantToDTORequest(EnseignantDTORequest enseignantRequest) {
        return new Enseignant(
                enseignantRequest.department(),
                enseignantRequest.cin(),
                enseignantRequest.nom(),
                enseignantRequest.prenom(),
                enseignantRequest.naissance(),
                enseignantRequest.sexe(),
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
                enseignantRequest.gradeEnseignant()

        );
    }
}
