package com.example.demo.gestionSurveillance.salle;


import com.example.demo.Doa.DepartementRepository;
import com.example.demo.Doa.EnseignantRepository;
import com.example.demo.Doa.SalleRepository;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Salle;
import com.example.demo.gestionSurveillance.enseignant.dto.EnseignantDTORequest;
import com.example.demo.gestionSurveillance.enseignant.dto.EnseignantDTOResponse;
import com.example.demo.gestionSurveillance.salle.dto.SalleDTORequest;
import com.example.demo.gestionSurveillance.salle.dto.SalleDTOResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.gestionSurveillance.enseignant.dto.mapper.EnseignantMappers.mapEnseignantToDTORequest;
import static com.example.demo.gestionSurveillance.enseignant.dto.mapper.EnseignantMappers.mapEnseignantToDTOResponse;
import static com.example.demo.gestionSurveillance.salle.dto.mapper.SalleMappers.mapSalleToDTORequest;
import static com.example.demo.gestionSurveillance.salle.dto.mapper.SalleMappers.mapSalleToDTOResponse;

@Service
@RequiredArgsConstructor
public class SurveillanceSalleService {

    @Autowired
    private SalleRepository salleRepository;

   public List<SalleDTOResponse> findAllSalleService(){
       // convertir list salle -> list salle DTOs
       List<Salle> salles = salleRepository.findAll();


       List<SalleDTOResponse> salleDTOResponses = new ArrayList<>() ;
       for (Salle salle : salles) {
           SalleDTOResponse salleDTOResponse = mapSalleToDTOResponse(salle);
           salleDTOResponses.add(salleDTOResponse);
       }
       return salleDTOResponses;

   }

   public void insertSalleService(SalleDTORequest salleRequest){
       Salle salle = mapSalleToDTORequest(salleRequest);
       salleRepository.save(salle);
   }



   public ResponseEntity<String> deleteSalleService(@PathVariable Long id) {
       Optional<Salle> salles = salleRepository.findById(id);

       if (salles.isPresent()) {
           Salle salle = salles.get();
           salleRepository.delete(salle);
           return ResponseEntity.ok("salle with ID " + id + " deleted successfully");
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("salle with ID " + id + " not found");
       }
   }
}
