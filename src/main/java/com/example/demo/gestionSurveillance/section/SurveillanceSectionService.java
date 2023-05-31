package com.example.demo.gestionSurveillance.section;


import com.example.demo.Doa.EnseignantMatiereRepository;
import com.example.demo.Doa.SectionRepository;
import com.example.demo.Doa.SemestreRepository;
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Section;
import com.example.demo.entities.Unite;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveillanceSectionService {

    @Autowired
    private SectionRepository sectionRepository;

   public List<Section> findAllSectionsService(){
       return sectionRepository.findAll();
   }


}
