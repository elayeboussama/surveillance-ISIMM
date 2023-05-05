package com.example.demo.controllersTest.enseignant.dto.enseignant.dto;

import com.example.demo.entities.Department;
import com.example.demo.entities.enums.Grade;
import com.example.demo.entities.enums.Sexe;

import java.util.Date;

public record EnseignantDTOResponse(
        Long id,
        Department department,
        String cin,
        String nom,
        String prenom,
        Date naissance,
        Sexe sexe,
        String adresse,
//        String password,
        String email,
        String telephone,
        int age,
        Date DateEmbauche,
        int NbJourCongeTotale,
        int NbJourCongeRestant,
        float Salaire,
        float nombreHeures,
        Grade gradeEnseignant
) {
}


