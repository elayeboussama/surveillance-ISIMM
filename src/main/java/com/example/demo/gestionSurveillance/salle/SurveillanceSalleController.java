package com.example.demo.gestionSurveillance.salle;

import com.example.demo.Doa.*;
import com.example.demo.gestionSurveillance.enseignant.SurveillanceEnseignantService;
import com.example.demo.gestionSurveillance.salle.dto.SalleDTORequest;
import com.example.demo.gestionSurveillance.salle.dto.SalleDTOResponse;
import com.example.demo.entities.Salle;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.gestionSurveillance.salle.dto.mapper.SalleMappers.*;


@RestController
@RequestMapping("/api/isimm/gestionSurveillance/salle")
@RequiredArgsConstructor
public class SurveillanceSalleController {

    private final SurveillanceSalleService salleService;




    @GetMapping(path="/all")
    public  List<SalleDTOResponse> findAllSalle() {
        return salleService.findAllSalleService();
    }

    @PostMapping(path="/insert")
    public  void insertSalle(@RequestBody SalleDTORequest salleRequest) {

        salleService.insertSalleService(salleRequest);
    }



        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteSalle(@PathVariable Long id) {
            return salleService.deleteSalleService(id);
        }







}
