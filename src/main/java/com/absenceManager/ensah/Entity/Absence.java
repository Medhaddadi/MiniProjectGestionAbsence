package com.absenceManager.ensah.Entity;


import com.absenceManager.ensah.Models.ModelAbsence;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbsence;
    //dateDebutAbsence
    private String dateDebutAbsence;
    //dateFinAbsence
    private String dateFinAbsence;
    // etat
    private int etat;
    // typeSaisie
    private String typeSaisie;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    public Absence(ModelAbsence modelAbsence) {
        this.idAbsence = modelAbsence.getIdAbsence();
        this.dateDebutAbsence = modelAbsence.getDateDebutAbsence();
        this.dateFinAbsence = modelAbsence.getDateFinAbsence();
        this.etat = modelAbsence.getEtat();
        this.typeSaisie = modelAbsence.getTypeSaisie();
        this.matiere = new Matiere(modelAbsence.getMatiere());
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    //belongs to insacription
    @ManyToOne
    private Inscription inscription;

    //belongs to matiere
    @ManyToOne
    private Matiere matiere;

    //belongs to observateur Ensignant
    @ManyToOne
    private Enseignant observateur;
}
