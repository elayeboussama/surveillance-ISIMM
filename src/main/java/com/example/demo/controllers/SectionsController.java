package com.example.demo.Controllers;


import com.example.demo.Doa.SectionRepository;
import com.example.demo.entities.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/section")
public class SectionsController {

    @Autowired
    private SectionRepository sectionRepository;

    @GetMapping
    public List<Section> findAllSections() {
        return sectionRepository.findAll();
    }

}