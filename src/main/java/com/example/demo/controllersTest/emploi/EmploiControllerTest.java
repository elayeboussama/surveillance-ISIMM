package com.example.demo.controllersTest.emploi;

import com.example.demo.Doa.*;
import com.example.demo.controllersTest.emploi.dto.EmploiDTORequest;
import com.example.demo.controllersTest.emploi.dto.EmploiDTOResponse;
import com.example.demo.entities.Emploi;
import com.example.demo.entities.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.controllersTest.emploi.dto.mapper.EmploiMappers.*;


@RestController
@RequestMapping("/api/emploi")
public class EmploiControllerTest {

    @Autowired
    private DepartementRepository departementRepository;
    @Autowired
    private EnseignantRepository enseignantRepository;
    @Autowired
    private EmploiRepository emploiRepository;
    @Autowired
    private RegimeRepository regimeRepository;
    @Autowired
    private UniteRepository uniteRepository;
    @Autowired
    private MatiereRepository matiereRepository;
    @Autowired
    private EnseignantMatiereRepository emploiMatiereRepository;




    @GetMapping(path="/all")
    public  List<EmploiDTOResponse> findAllEmploi() {
        // convertir list emploi -> list emploi DTOs
        List<Emploi> emplois = emploiRepository.findAll();;


        List<EmploiDTOResponse> emploiDTORespons = new ArrayList<>() ;
        for (Emploi emploi : emplois) {
            EmploiDTOResponse emploiDTOResponse = mapEmploiToDTOResponse(emploi);
            emploiDTORespons.add(emploiDTOResponse);
        }
        return emploiDTORespons;




    }

    @PostMapping(path="/insert")
    public  void insertEnsignant(@RequestBody EmploiDTORequest emploiRequest) {


         Emploi emploi = mapEmploiToDTORequest(emploiRequest);
        emploiRepository.save(emploi);

    }



        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteUser(@PathVariable Long id) {
            Optional<Emploi> emplois  = emploiRepository.findById(id);

            if (emplois.isPresent()) {
                Emploi emploi = emplois.get();
                emploiRepository.delete(emploi);
                return ResponseEntity.ok("emploi with ID " + id + " deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("emploi with ID " + id + " not found");
            }
        }







//    @PostMapping(path="/insert")
//    public @ResponseBody void insert() {
//
//        Department dp = new Department("ing");

//deux instance mo5talfin

//        Emploi ens = new Emploi(dp,"14020269","elayeb", "oussama",java.sql.Date.valueOf("2000-12-25"), Sexe.HOMME,"Moknine","Oussama.123", "elayeb.oussama2020@gmail.com","53273102",23,java.sql.Date.valueOf("2020-09-12"),45,45,1200,18, Grade.ASSISTANT);
//        Emploi ens2 = new Emploi(dp,"14020269","elayeb", "oussama",java.sql.Date.valueOf("2000-12-25"), Sexe.HOMME,"Moknine","Oussama.123", "elayeb.oussama2020@gmail.com","53273102",23,java.sql.Date.valueOf("2020-09-12"),45,45,1200,18, Grade.ASSISTANT);
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
//        emploiRepository.save(ens); // lenna a3maltelhom save fel bd
//        emploiRepository.save(ens2);
//
//        //
//        System.out.println("--------------------ens1------------------------"+ens.getId());
//        System.out.println("--------------------ens2------------------------"+ens.getId());
//        EmploiMatiere es = new EmploiMatiere(ens2,mt, Session.CR, Groups.SECTION,Long.parseLong("1"));
//        EmploiMatiere es2 = new EmploiMatiere(ens,mt, Session.CR, Groups.SECTION,Long.parseLong("2"));
//        mt.addEmploiMatiere(es);
//        ens.addEmploiMatiere(es);
//
//        departementRepository.save(dp);
//        emploiRepository.save(ens);
//        emploiRepository.save(ens2);
//        uniteRepository.save(u);
//        regimeRepository.save(r);
//        matiereRepository.save(mt);
//        emploiMatiereRepository.save(es);
//        emploiMatiereRepository.save(es2);


//    }
}
