package com.example.demo.controllersTest.salle;

import com.example.demo.Doa.*;
import com.example.demo.controllersTest.salle.dto.SalleDTORequest;
import com.example.demo.controllersTest.salle.dto.SalleDTOResponse;
import com.example.demo.entities.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.controllersTest.salle.dto.mapper.SalleMappers.*;


@RestController
@RequestMapping("/api/salle")
public class SalleControllerTest {

    @Autowired
    private DepartementRepository departementRepository;
    @Autowired
    private EnseignantRepository enseignantRepository;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private RegimeRepository regimeRepository;
    @Autowired
    private UniteRepository uniteRepository;
    @Autowired
    private MatiereRepository matiereRepository;
    @Autowired
    private EnseignantMatiereRepository salleMatiereRepository;




    @GetMapping(path="/all")
    public  List<SalleDTOResponse> findAllSalle() {
        // convertir list salle -> list salle DTOs
        List<Salle> salles = salleRepository.findAll();;


        List<SalleDTOResponse> salleDTOResponses = new ArrayList<>() ;
        for (Salle salle : salles) {
            SalleDTOResponse salleDTOResponse = mapSalleToDTOResponse(salle);
            salleDTOResponses.add(salleDTOResponse);
        }
        return salleDTOResponses;




    }

    @PostMapping(path="/insert")
    public  void insertEnsignant(@RequestBody SalleDTORequest salleRequest) {


         Salle salle = mapSalleToDTORequest(salleRequest);
        salleRepository.save(salle);

    }



        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteUser(@PathVariable Long id) {
            Optional<Salle> salles  = salleRepository.findById(id);

            if (salles.isPresent()) {
                Salle salle = salles.get();
                salleRepository.delete(salle);
                return ResponseEntity.ok("salle with ID " + id + " deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("salle with ID " + id + " not found");
            }
        }







//    @PostMapping(path="/insert")
//    public @ResponseBody void insert() {
//
//        Department dp = new Department("ing");

//deux instance mo5talfin

//        Salle ens = new Salle(dp,"14020269","elayeb", "oussama",java.sql.Date.valueOf("2000-12-25"), Sexe.HOMME,"Moknine","Oussama.123", "elayeb.oussama2020@gmail.com","53273102",23,java.sql.Date.valueOf("2020-09-12"),45,45,1200,18, Grade.ASSISTANT);
//        Salle ens2 = new Salle(dp,"14020269","elayeb", "oussama",java.sql.Date.valueOf("2000-12-25"), Sexe.HOMME,"Moknine","Oussama.123", "elayeb.oussama2020@gmail.com","53273102",23,java.sql.Date.valueOf("2020-09-12"),45,45,1200,18, Grade.ASSISTANT);
//
//
//
//        Regime r = new Regime("math",1,512,10,10,10,0);
//
//
//        Unite u = new Unite(142,"maths",6,7);
//
//
//
//        Matiere mt = new Matiere("math",3.5f,1.5f,1,1,1,1,512,10,10,10,0,0,r,u);
//        departementRepository.save(dp);
//
//        salleRepository.save(ens); // lenna a3maltelhom save fel bd
//        salleRepository.save(ens2);
//
//        //
//        System.out.println("--------------------ens1------------------------"+ens.getId());
//        System.out.println("--------------------ens2------------------------"+ens.getId());
//        SalleMatiere es = new SalleMatiere(ens2,mt, Session.CR, Groups.SECTION,Long.parseLong("1"));
//        SalleMatiere es2 = new SalleMatiere(ens,mt, Session.CR, Groups.SECTION,Long.parseLong("2"));
//        mt.addSalleMatiere(es);
//        ens.addSalleMatiere(es);
//
//        departementRepository.save(dp);
//        salleRepository.save(ens);
//        salleRepository.save(ens2);
//        uniteRepository.save(u);
//        regimeRepository.save(r);
//        matiereRepository.save(mt);
//        salleMatiereRepository.save(es);
//        salleMatiereRepository.save(es2);


//    }
}
