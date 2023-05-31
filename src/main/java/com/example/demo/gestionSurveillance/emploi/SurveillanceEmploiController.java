package com.example.demo.gestionSurveillance.emploi;

import com.example.demo.Doa.*;
import com.example.demo.gestionSurveillance.emploi.dto.EmploiDTORequest;
import com.example.demo.gestionSurveillance.emploi.dto.EmploiDTOResponse;
import com.example.demo.entities.Emploi;
import com.example.demo.gestionSurveillance.emploi.dto.EmploiRequestForGenerating;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.gestionSurveillance.emploi.dto.mapper.EmploiMappers.*;


@RestController
@RequestMapping("/api/isimm/gestionSurveillance/emploi")
@RequiredArgsConstructor
public class SurveillanceEmploiController {





    private final SurveillanceEmploiService emploiService;


    @GetMapping(path="/all")
    public  List<EmploiDTOResponse> findAllEmploi() {
        return emploiService.findAllEmploiService();






    }

    @PostMapping(path="/insert")
    public  void insertEmploi(@RequestBody EmploiDTORequest emploiRequest) {

        emploiService.insertEmploiService(emploiRequest);

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmploi(@PathVariable Long id) {
        return emploiService.deleteEmploiService(id);
    }







    @PostMapping("/create")
    public String CreateEmploi(
            @RequestBody EmploiRequestForGenerating request

    ) {

        JSONObject instance = emploiService.createEmploi(request);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println(instance);
        return instance.toString();
    }


}
