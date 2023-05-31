package com.example.demo.gestionSurveillance.emploi.dto;

import java.util.List;

public record Section (int id, String name, List<ReqMatiere> matieres) { }