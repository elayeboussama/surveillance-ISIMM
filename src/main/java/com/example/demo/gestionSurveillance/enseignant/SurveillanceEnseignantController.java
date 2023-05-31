package com.example.demo.gestionSurveillance.enseignant;

import com.example.demo.Doa.*;
import com.example.demo.entities.enums.Grade;
import com.example.demo.entities.enums.Groups;
import com.example.demo.entities.enums.Session;
import com.example.demo.entities.enums.Sexe;
import com.example.demo.gestionSurveillance.enseignant.dto.EnseignantDTORequest;
import com.example.demo.gestionSurveillance.enseignant.dto.EnseignantDTOResponse;
import com.example.demo.entities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.demo.gestionSurveillance.enseignant.dto.mapper.EnseignantMappers.mapEnseignantToDTORequest;

@RestController
@RequestMapping("/api/isimm/gestionSurveillance/enseignant/ ")
@RequiredArgsConstructor
public class SurveillanceEnseignantController {

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


    private final SurveillanceEnseignantService enseignantService;


    @GetMapping(path="/all")
    public  List<EnseignantDTOResponse> findAllEnsignant() {
        return enseignantService.findAllEnsignantService();
    }

    @GetMapping(path="/ens")
    public @ResponseBody List<EnseignantMatiere> findAllEnseignantMatiere() {
        return enseignantService.findAllEnseignantMatiereService();

    }

    @PostMapping(path="/insert")
    public  void insertEnsignant(@RequestBody EnseignantDTORequest enseignantRequest) {
        enseignantService.insertEnseignantService(enseignantRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnseignant(@PathVariable Long id) {
        return enseignantService.deleteEnseignantService(id);
    }

    @PostMapping(path="/insertTest")
    public @ResponseBody void insertEnseignantTest() {

        enseignantService.insertEnseignantTestService();


    }


}
