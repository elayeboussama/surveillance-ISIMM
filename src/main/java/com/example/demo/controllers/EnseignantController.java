package com.example.demo.controllers;

import com.example.demo.Doa.EnseignantRepository;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enseignant")
public class EnseignantController {
    @Autowired
    private EnseignantRepository enseignantRepository;

    @GetMapping(path="/all")
    public @ResponseBody List<Enseignant> findAllUsers() {

        return enseignantRepository.findAll();
    }
}
