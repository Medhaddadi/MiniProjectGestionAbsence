package com.absenceManager.ensah.Models;

import com.absenceManager.ensah.Entity.Absence;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class ModelAbsence {

    private Long idAbsence;

    private String dateDebutAbsence;

    private String dateFinAbsence;

    private int etat;

    private String typeSaisie;
    private ModelInscription inscription;

    private ModelMatiere matiere;

    private ModelEnseignant observateur;

    public ModelAbsence(Absence absence) {
        this.idAbsence = absence.getIdAbsence();
        this.dateDebutAbsence = absence.getDateDebutAbsence();
        this.dateFinAbsence = absence.getDateFinAbsence();
        this.etat = absence.getEtat();
        this.typeSaisie = absence.getTypeSaisie();
        this.inscription = new ModelInscription(absence.getInscription());
        this.matiere = new ModelMatiere(absence.getMatiere());
    }
}
