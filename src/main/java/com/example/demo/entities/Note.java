package com.example.demo.entities;


import com.example.demo.entities.enums.TypeDevoir;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
public class Note implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_note", nullable = false)
    private Long idNote;


    @ManyToOne()
    @JoinColumn(name="id_matiere")
    private Matiere matiere;

    @ManyToOne()
    @JoinColumn(name="id_etudiant")
    private Etudiant etudiant;

    @ManyToOne()
    @JoinColumn(name="id_enseingant")
    private Enseignant enseingant;


    @Column
    private TypeDevoir type;

private float note;
private Date date;
    public Note() {

    }

    public Note(Matiere matiere, Etudiant etudiant, Enseignant enseingant, TypeDevoir type, float note, Date date) {

        this.matiere = matiere;
        this.etudiant = etudiant;
        this.enseingant = enseingant;
        this.type = type;
        this.note = note;
        this.date = date;
    }

}

