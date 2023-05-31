package com.example.demo.Doa;

import com.example.demo.entities.DemandeConger;
import com.example.demo.entities.EnseignantMatiere;
import com.example.demo.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantMatiereRepository extends JpaRepository<EnseignantMatiere, Long> {


    List<Matiere> findByEnseignantId(Long enseignantId);
}