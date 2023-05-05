package com.example.demo.security.auth;


import com.example.demo.entities.*;
import com.example.demo.entities.enums.Grade;
import com.example.demo.entities.enums.Sexe;
import com.example.demo.entities.enums.TypeStaff;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {


  private String departement;
  private String cin;
  private String nom;
  private String prenom;
  private Date naissance;
  private Sexe sexe;
  private String adresse ;
  private String password;
  private String email;
  private String telephone;
  private int age;
  private String role;
  private Date DateEmbauche;
  private int NbJourCongeTotale;
  private int NbJourCongeRestant;
  private float Salaire;
//  private Set<Service> services;
  private Department department;
//  private Set<DemandeConger> demandeConger;
//  private Set<DemandeStockable> demandeStockable;
//  private Set<Voeux> voeux;
//  private Set<EnseignantMatiere> enseignantMatiere ;
//  private Set<Note> notes;
  private float NombreHeures;
  private Grade gradeEnseignant;
  private TypeStaff typeStaff;
}
