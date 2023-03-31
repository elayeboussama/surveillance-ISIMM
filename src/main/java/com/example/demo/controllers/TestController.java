package com.example.demo.controllers;

import com.example.demo.Doa.*;
import com.example.demo.entities.*;
import com.example.demo.entities.enums.Grade;
import com.example.demo.entities.enums.Groups;
import com.example.demo.entities.enums.Session;
import com.example.demo.entities.enums.Sexe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    private DepartementRepository departementRepository;
    @Autowired
    private EnseignantRepository enseignantRepository;
    @Autowired
    private RegimeRepository regimeRepository;
    @Autowired
    private UniteRepository uniteRepository;
    @Autowired
    private MatiereRepository matiereRepository;
    @Autowired
    private EnseignantMatiereRepository enseignantMatiereRepository;


    @PostMapping(path="/all")
    public @ResponseBody void findAllEnsignant() {


        Department departement = new Department("Informatique");
        departementRepository.save(departement);

        String cin = "AB123456";
        String nom = "Dupont";
        String prenom = "Jean";
        Date naissance = new Date(1990, 1, 1); // 1 février 1990
        Sexe sexe = Sexe.HOMME;
        String adresse = "1 rue de la Paix";
        String password = "secret";
        String email = "jean.dupont@example.com";
        String telephone = "01 23 45 67 89";
        int age = 32;
        Date dateEmbauche = new Date(2020, 9, 1); // 1 septembre 2020
        int nbJourCongeTotale = 25;
        int nbJourCongeRestant = 20;
        float salaire = 2500.0f;
        float nombreHeures = 18.0f;
        Grade gradeEnseignant = Grade.PROF;

        Enseignant enseignant = new Enseignant(departement, cin, nom, prenom, naissance, sexe, adresse, password, email, telephone, age, dateEmbauche, nbJourCongeTotale, nbJourCongeRestant, salaire, nombreHeures, gradeEnseignant);
        enseignantRepository.save(enseignant);

// create an instance of Matiere



        Regime myRegime = new Regime("Mon régime", 2, 6, 10, 12, 8, 6);
        Unite myUnite = new Unite(514,"Programmation Orientée Objet", 1.5f, 4.0f);
        regimeRepository.save(myRegime);
        uniteRepository.save(myUnite);

        // bhi la74a bark
        Matiere matiere = new Matiere("c",6.0f, 1, 2, 2, 1, 1, 123456, 30, 45, 30, 15, 0,0,myRegime, myUnite);
        matiereRepository.save(matiere);
        EnseignantMatiere enseignantMatiere = new EnseignantMatiere(enseignant, matiere, Session.TP, Groups.TP, 1L);

        enseignantMatiereRepository.save(enseignantMatiere);



    }

}
