package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Emploi")
@Data
public class Emploi implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id_emploi", nullable = false)
        private Long idEmploi;


    @Column
    private Date dateDebut;

    @Column
    private Date dateFin;

    @OneToMany(mappedBy = "emploi",fetch=FetchType.LAZY)
    private Set<Seance> seances;


    public Emploi() {
    }





}