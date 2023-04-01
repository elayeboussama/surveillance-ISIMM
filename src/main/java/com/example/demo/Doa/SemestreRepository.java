package com.example.demo.Doa;

import com.example.demo.entities.Matiere;
import com.example.demo.entities.Semestre;
import com.example.demo.entities.Unite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SemestreRepository extends JpaRepository<Semestre, Long> {

@Query("SELECT u FROM Unite u JOIN u.semestres s JOIN s.sections section WHERE section.idSection = :sectionId")
List<Unite> findUniteBySectionId(@Param("sectionId") Long sectionId);



}