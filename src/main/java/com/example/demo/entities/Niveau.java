package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Niveau implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_niveau", nullable = false)
    private Long idNiveau;

    @Column(length = 100)
    private String name;


    @ManyToOne
    @JoinColumn(name="myDiplome")
    private Diplome diplome;

    @OneToMany(mappedBy = "niveau",fetch=FetchType.LAZY)
    private Set<Semestre> semestres;










    public Niveau() {

    }

    public Niveau(String name, Set<Semestre> semestres) {
        this.name = name;
        this.semestres = semestres;
    }

    public Niveau(String name) {
        this.name = name;
        this.semestres = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addSemestre(Semestre semestre) {
        this.semestres.add(semestre);
    }
}

