package com.example.demo.entities;

import com.example.demo.entities.enums.grade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Enseignant")
@Getter
@Setter
public class Enseignant extends Employer  {

//    @Id
//    @GeneratedValue
//    @Column(name = "id_enseignant", nullable = false)
//    private Long idEnseignant;

    @OneToMany(mappedBy="enseignant",fetch=FetchType.LAZY)
    private Set<Voeux> voeux;

    private Set<EnseignantMatiere> enseignantMatiere = new HashSet<EnseignantMatiere>();


    @OneToMany(mappedBy = "enseingant",fetch=FetchType.LAZY)
    private Set<Note> notes;



    private float NombreHeures;

    private grade gradeEnseignant ;


    public Enseignant() {

    }
    public Enseignant(float NombreHeures, String NiveauEnseigné, grade gradeEnseignant , Department department, Set<DemandeConger> demandeConger, Set<DemandeStockable> demandeStockable, String cin, String nom, String prénom, Date naissance, Sexe sexe, String adresse, String password, String email, String telephone, int age, Date DateEmbauche, int NbJourCongeTotale, int NbJourCongeRestant, float Salaire) {
        super(department, demandeConger, demandeStockable, cin, nom, prénom, naissance, sexe, adresse, password, email, telephone, age, DateEmbauche, NbJourCongeTotale, NbJourCongeRestant, Salaire);
        this.NombreHeures = NombreHeures;

        this.gradeEnseignant = gradeEnseignant;
    }


    public Set<Voeux> getVoeux() {
        return voeux;
    }

    public void setVoeux(Set<Voeux> voeux) {
        this.voeux = voeux;
    }

    @OneToMany(mappedBy = "enseignant")
    public Set<EnseignantMatiere> getEnseignantMatiere() {
        return enseignantMatiere;
    }

    public void setEnseignantMatiere(Set<EnseignantMatiere> enseignantMatiere) {
        this.enseignantMatiere = enseignantMatiere;
    }




}
