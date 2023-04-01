package com.example.demo.controllers;

import com.example.demo.Doa.EnseignantMatiereRepository;
import com.example.demo.Doa.SemestreRepository;
import com.example.demo.Doa.UniteRepository;
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Unite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/matiere")
public class MatiereController {
    @Autowired
    private EnseignantMatiereRepository enseignantMatiereRepository;
    @Autowired
    private SemestreRepository semestreRepository;

    @GetMapping(path="/enseignant/{id}")
    public List<Matiere> getMatieresByEnseignant(@PathVariable(value="id") Long enseignantId) {
        return enseignantMatiereRepository.findByEnseignantId(enseignantId);
    }

    @GetMapping(path="/section/{id}")
    public List<Matiere> getMatieresBySection(@PathVariable(value="id") Long sectionId) {
        List<Matiere> result = new ArrayList<>();
        List<Unite> unites = semestreRepository.findUniteBySectionId(sectionId);
        for (Unite unite : unites) {
            for (Matiere matiere : unite.getMatieres()) {

                    result.add(matiere);

            }
        }
        return result;
    }


}
