package com.example.demo.controllersTest.emploi.dto;

import com.example.demo.entities.Department;
import com.example.demo.entities.enums.Grade;
import com.example.demo.entities.enums.Sexe;

import java.util.Date;

public record EmploiDTORequest(
        Date dateDebut, Date dateFin
    ){
}
