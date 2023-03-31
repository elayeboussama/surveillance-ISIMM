package com.example.demo.controllers;

import com.example.demo.Doa.EnseignantMatiereRepository;
import com.example.demo.entities.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matiere")
public class MatiereController {
    @Autowired
    private EnseignantMatiereRepository enseignantMatiereRepository;
   /* @GetMapping(path="/enseignant/{id}")
    public List<Matiere> getMatieresByEnseignant(@PathVariable(value="id") Long enseignantId) {
        return enseignantMatiereRepository.findByEnseignantId(enseignantId);
    }*/
}
