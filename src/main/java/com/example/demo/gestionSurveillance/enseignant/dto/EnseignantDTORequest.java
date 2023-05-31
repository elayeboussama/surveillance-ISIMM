package com.example.demo.gestionSurveillance.enseignant.dto;

import com.example.demo.entities.enums.Grade;
import com.example.demo.entities.enums.Sexe;

import java.util.Date;

public record EnseignantDTORequest(


    String cin,
    String nom,
    String prenom,
    Date naissance,
    Sexe sexe,
    String adresse,
    String password,
    String email,
    String telephone,
    int age,

    Date DateEmbauche,
    int NbJourCongeTotale,
    int NbJourCongeRestant,
    float Salaire,
    Long department,
    float nombreHeures,
    Grade gradeEnseignant
    ){
}
