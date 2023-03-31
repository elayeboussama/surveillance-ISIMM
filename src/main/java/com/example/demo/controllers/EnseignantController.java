package com.example.demo.controllers;

import com.example.demo.Doa.*;
import com.example.demo.entities.*;
import com.example.demo.entities.enums.Grade;
import com.example.demo.entities.enums.Groups;
import com.example.demo.entities.enums.Session;
import com.example.demo.entities.enums.Sexe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enseignant")
public class EnseignantController {
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


    @GetMapping(path="/all")
    public @ResponseBody List<Enseignant> findAllEnsignant() {

        return enseignantRepository.findAll();


    }

    @GetMapping(path="/ens")
    public @ResponseBody List<EnseignantMatiere> findAllEnseignantMatiere() {

        return enseignantMatiereRepository.findAll();


    }


    @PostMapping(path="/insert")
    public @ResponseBody void insert() {

        Department dp = new Department("ing");



        Enseignant ens = new Enseignant(dp,"14020269","elayeb", "oussama",java.sql.Date.valueOf("2000-12-25"), Sexe.HOMME,"Moknine","Oussama.123", "elayeb.oussama2020@gmail.com","53273102",23,java.sql.Date.valueOf("2020-09-12"),45,45,1200,18, Grade.ASSISTANT);
        Enseignant ens2 = new Enseignant(dp,"14020269","elayeb", "oussama",java.sql.Date.valueOf("2000-12-25"), Sexe.HOMME,"Moknine","Oussama.123", "elayeb.oussama2020@gmail.com","53273102",23,java.sql.Date.valueOf("2020-09-12"),45,45,1200,18, Grade.ASSISTANT);



        Regime r = new Regime("math",1,1,1,1,512,10,10,10,0,0);



        Unite u = new Unite(142,"maths",6,7);



        Matiere mt = new Matiere("math",3.5f,1.5f,1,1,1,1,1,512,10,10,10,0,0,r,u);
        departementRepository.save(dp);

        enseignantRepository.save(ens);
        enseignantRepository.save(ens2);



        System.out.println("--------------------ens1------------------------"+ens.getId());
        System.out.println("--------------------ens2------------------------"+ens.getId());
        EnseignantMatiere es = new EnseignantMatiere(ens2,mt, Session.CR, Groups.SECTION,Long.parseLong("1"));
        EnseignantMatiere es2 = new EnseignantMatiere(ens,mt, Session.CR, Groups.SECTION,Long.parseLong("2"));

        mt.addEnseignantMatiere(es);
        ens.addEnseignantMatiere(es);

        departementRepository.save(dp);
        enseignantRepository.save(ens);
        enseignantRepository.save(ens2);
        uniteRepository.save(u);
        regimeRepository.save(r);
        matiereRepository.save(mt);
        enseignantMatiereRepository.save(es);
        enseignantMatiereRepository.save(es2);


    }
}
