package com.example.demo.gestionSurveillance.matiere;

import com.example.demo.Doa.*;
import com.example.demo.entities.EnseignantMatiere;
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Unite;
import com.example.demo.gestionSurveillance.enseignant.SurveillanceEnseignantService;
import com.example.demo.gestionSurveillance.enseignant.dto.EnseignantDTORequest;
import com.example.demo.gestionSurveillance.enseignant.dto.EnseignantDTOResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/isimm/gestionSurveillance/enseignant/ ")
@RequiredArgsConstructor
public class SurveillanceMatiereController {
    private final SurveillanceMatiereService matiereService;
    @Autowired
    private EnseignantMatiereRepository enseignantMatiereRepository;
    @Autowired
    private SemestreRepository semestreRepository;

    @GetMapping(path="/enseignant/{id}")
    public List<Matiere> getMatieresByEnseignant(@PathVariable(value="id") Long enseignantId) {
        return  matiereService.getMatieresByEnseignantService(enseignantId) ;
    }

    @GetMapping(path="/section/{id}")
    public List<Matiere> getMatieresBySection(@PathVariable(value="id") Long sectionId) {
        return  matiereService.getMatieresBySectionService(sectionId) ;
    }


}
