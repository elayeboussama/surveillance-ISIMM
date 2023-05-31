package com.example.demo.gestionSurveillance.emploi.dto;

import java.util.Date;
import java.util.List;

public record EmploiRequestForGenerating(String name, List<Section> sections, Date dateDebut, Date dateFin, int numberOfSessions) {
}
