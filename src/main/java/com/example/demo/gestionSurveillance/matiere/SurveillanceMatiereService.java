package com.example.demo.gestionSurveillance.matiere;


import com.example.demo.Doa.*;
import com.example.demo.entities.*;
import com.example.demo.entities.enums.Grade;
import com.example.demo.entities.enums.Groups;
import com.example.demo.entities.enums.Session;
import com.example.demo.entities.enums.Sexe;
import com.example.demo.gestionSurveillance.enseignant.dto.EnseignantDTORequest;
import com.example.demo.gestionSurveillance.enseignant.dto.EnseignantDTOResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.gestionSurveillance.enseignant.dto.mapper.EnseignantMappers.mapEnseignantToDTORequest;
import static com.example.demo.gestionSurveillance.enseignant.dto.mapper.EnseignantMappers.mapEnseignantToDTOResponse;

@Service
@RequiredArgsConstructor
public class SurveillanceMatiereService {

    @Autowired
    private EnseignantMatiereRepository enseignantMatiereRepository;
    @Autowired
    private SemestreRepository semestreRepository;

   public List<Matiere> getMatieresByEnseignantService(Long id){
       return enseignantMatiereRepository.findByEnseignantId(id);
   }
    public List<Matiere> getMatieresBySectionService(Long id){
        List<Matiere> result = new ArrayList<>();
        List<Unite> unites = semestreRepository.findUniteBySectionId(id);
        for (Unite unite : unites) {
            for (Matiere matiere : unite.getMatieres()) {

                result.add(matiere);

            }
        }
        return result;
    }

}
