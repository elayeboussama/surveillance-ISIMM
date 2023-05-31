package com.example.demo.gestionSurveillance.section;

import com.example.demo.Doa.EnseignantMatiereRepository;
import com.example.demo.Doa.SectionRepository;
import com.example.demo.Doa.SemestreRepository;
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Section;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/isimm/gestionSurveillance/enseignant/ ")
@RequiredArgsConstructor
public class SurveillanceSectionController {
    private final SurveillanceSectionService sectionService;


    @GetMapping
    public List<Section> findAllSections() {
        return sectionService.findAllSectionsService() ;
    }



}



