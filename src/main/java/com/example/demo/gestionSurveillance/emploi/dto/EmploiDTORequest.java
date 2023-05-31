package com.example.demo.gestionSurveillance.emploi.dto;

import java.util.Date;

public record EmploiDTORequest(
        Date dateDebut, Date dateFin, Long enseignant
    ){
}
