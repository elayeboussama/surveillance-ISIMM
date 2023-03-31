package com.example.demo.Doa;

import com.example.demo.entities.DemandeConger;
import com.example.demo.entities.EnseignantMatiere;
import com.example.demo.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantMatiereRepository extends JpaRepository<EnseignantMatiere, Long> {
    @Query("SELECT em.matiere FROM EnseignantMatiere em WHERE em.enseignant.id = :enseignantId")
    List<Matiere> findByEnseignantId(@Param("enseignantId") Long enseignantId);

  /*  @Query("SELECT em.matiere FROM EnseignantMatiere em JOIN  em.enseignant e JOIN e.personne p WHERE p.id = :enseignantId")
    List<Matiere> findByEnseignantId(@Param("enseignantId") Long enseignantId);*/

}