package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Salle")
@Data
public class Salle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_salle", nullable = false)
    private Long idSalle;


    @Column
    private Boolean disponibilité;

    @OneToMany(mappedBy = "salle",fetch=FetchType.LAZY)
    private Set<Seance> Seances;


    public Salle() {
    }





}
