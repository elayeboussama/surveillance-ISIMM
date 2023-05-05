package com.example.demo.controllersTest.emploi.dto.mapper;

import com.example.demo.controllersTest.emploi.dto.EmploiDTORequest;
import com.example.demo.controllersTest.emploi.dto.EmploiDTOResponse;
import com.example.demo.entities.Emploi;

public class EmploiMappers {

    public static EmploiDTOResponse mapEmploiToDTOResponse(Emploi emploi) {
        return new EmploiDTOResponse(
                emploi.getDateDebut(),
                emploi.getDateFin()


        );
    }

    public static Emploi mapEmploiToDTORequest(EmploiDTORequest emploiRequest) {
        return new Emploi(
                emploiRequest.dateDebut(),
                emploiRequest.dateFin()

        );
    }
}
