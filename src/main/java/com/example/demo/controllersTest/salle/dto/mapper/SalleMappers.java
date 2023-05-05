package com.example.demo.controllersTest.salle.dto.mapper;

import com.example.demo.controllersTest.salle.dto.SalleDTORequest;
import com.example.demo.controllersTest.salle.dto.SalleDTOResponse;
import com.example.demo.entities.Emploi;
import com.example.demo.entities.Salle;

public class SalleMappers {

    public static SalleDTOResponse mapSalleToDTOResponse(Salle salle) {
        return new SalleDTOResponse(
                salle.getDisponibilité()
        );
    }

    public static Salle mapSalleToDTORequest(SalleDTORequest salleRequest) {
        return new Salle(
                salleRequest.disponibilité()
        );
    }
}
