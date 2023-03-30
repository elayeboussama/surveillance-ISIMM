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
public class Section implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_section", nullable = false)
    private Long idSection;

    @Column(length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="semestre")
    private Semestre semestre;

    @OneToMany(mappedBy = "section", fetch = FetchType.LAZY)
    private Set<TD> tds;




    public Section() {

    }

    public Section(String name, Semestre semestre, Set<TD> tds) {
        this.name = name;
        this.semestre = semestre;
        this.tds = tds;
    }

    public Section(String name, Semestre semestre) {
        this.name = name;
        this.semestre = semestre;
        this.tds = new HashSet<>();
    }

    public void addTd(TD td) {
        this.tds.add(td);
    }
}

