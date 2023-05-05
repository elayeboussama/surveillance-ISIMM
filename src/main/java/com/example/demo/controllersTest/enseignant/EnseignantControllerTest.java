package com.example.demo.controllersTest.enseignant;

import com.example.demo.Doa.*;
import com.example.demo.controllersTest.enseignant.dto.EnseignantDTORequest;
import com.example.demo.controllersTest.enseignant.dto.EnseignantDTOResponse;
import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.controllersTest.enseignant.dto.mapper.EnseignantMappers.mapEnseignantToDTORequest;
import static com.example.demo.controllersTest.enseignant.dto.mapper.EnseignantMappers.mapEnseignantToDTOResponse;

@RestController
@RequestMapping("/api/enseignant")
public class EnseignantControllerTest {

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
    public  List<EnseignantDTOResponse> findAllEnsignant() {
        // convertir list enseignant -> list enseignant DTOs
        List<Enseignant> enseignants = enseignantRepository.findAll();;


        List<EnseignantDTOResponse> enseignantDTOResponses = new ArrayList<>() ;
        for (Enseignant enseignant : enseignants) {
            EnseignantDTOResponse enseignantDTOResponse = mapEnseignantToDTOResponse(enseignant);
            enseignantDTOResponses.add(enseignantDTOResponse);
        }
        return enseignantDTOResponses;




    }

    @PostMapping(path="/insert")
    public  void insertEnsignant(@RequestBody EnseignantDTORequest enseignantRequest) {


         Enseignant enseignant = mapEnseignantToDTORequest(enseignantRequest);
        enseignantRepository.save(enseignant);

    }



        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteUser(@PathVariable Long id) {
            Optional<Enseignant> enseignants  = enseignantRepository.findById(id);

            if (enseignants.isPresent()) {
                Enseignant enseignant = enseignants.get();
                enseignantRepository.delete(enseignant);
                return ResponseEntity.ok("enseignant with ID " + id + " deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("enseignant with ID " + id + " not found");
            }
        }







//    @PostMapping(path="/insert")
//    public @ResponseBody void insert() {
//
//        Department dp = new Department("ing");

//deux instance mo5talfin

//        Enseignant ens = new Enseignant(dp,"14020269","elayeb", "oussama",java.sql.Date.valueOf("2000-12-25"), Sexe.HOMME,"Moknine","Oussama.123", "elayeb.oussama2020@gmail.com","53273102",23,java.sql.Date.valueOf("2020-09-12"),45,45,1200,18, Grade.ASSISTANT);
//        Enseignant ens2 = new Enseignant(dp,"14020269","elayeb", "oussama",java.sql.Date.valueOf("2000-12-25"), Sexe.HOMME,"Moknine","Oussama.123", "elayeb.oussama2020@gmail.com","53273102",23,java.sql.Date.valueOf("2020-09-12"),45,45,1200,18, Grade.ASSISTANT);
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
//        enseignantRepository.save(ens); // lenna a3maltelhom save fel bd
//        enseignantRepository.save(ens2);
//
//        //
//        System.out.println("--------------------ens1------------------------"+ens.getId());
//        System.out.println("--------------------ens2------------------------"+ens.getId());
//        EnseignantMatiere es = new EnseignantMatiere(ens2,mt, Session.CR, Groups.SECTION,Long.parseLong("1"));
//        EnseignantMatiere es2 = new EnseignantMatiere(ens,mt, Session.CR, Groups.SECTION,Long.parseLong("2"));
//        mt.addEnseignantMatiere(es);
//        ens.addEnseignantMatiere(es);
//
//        departementRepository.save(dp);
//        enseignantRepository.save(ens);
//        enseignantRepository.save(ens2);
//        uniteRepository.save(u);
//        regimeRepository.save(r);
//        matiereRepository.save(mt);
//        enseignantMatiereRepository.save(es);
//        enseignantMatiereRepository.save(es2);


//    }
}
