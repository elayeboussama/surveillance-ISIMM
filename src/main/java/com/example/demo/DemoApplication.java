package com.example.demo;

import com.example.demo.Doa.*;
import com.example.demo.entities.*;
import com.example.demo.entities.enums.Grade;
import com.example.demo.entities.enums.Groups;
import com.example.demo.entities.enums.Session;
import com.example.demo.entities.enums.Sexe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(DemoApplication.class, args);

		EnseignantRepository enseignantRepository = context.getBean(EnseignantRepository.class);
		MatiereRepository matiereRepository = context.getBean(MatiereRepository.class);
		EnseignantMatiereRepository enseignantMatiereRepository  = context.getBean(EnseignantMatiereRepository .class);
		DepartementRepository departementRepository  = context.getBean(DepartementRepository .class);
		RegimeRepository regimeRepository  = context.getBean(RegimeRepository .class);
		UniteRepository uniteRepository  = context.getBean(UniteRepository .class);


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



		Regime myRegime = new Regime("Mon régime", 2, 3, 4, 5, 6, 10, 12, 8, 6, 4);
		Unite myUnite = new Unite("Programmation Orientée Objet", 1.5f, 4.0f);
		regimeRepository.save(myRegime);
		uniteRepository.save(myUnite);


		Matiere matiere = new Matiere("c", 6.0f, 1, 2, 2, 1, 1, 123456, 30, 45, 30, 15, 0, myRegime, myUnite);
		matiereRepository.save(matiere);
		EnseignantMatiere enseignantMatiere = new EnseignantMatiere(enseignant, matiere, Session.TP, Groups.TP, 1L);

		enseignantMatiereRepository.save(enseignantMatiere);

	}


}


