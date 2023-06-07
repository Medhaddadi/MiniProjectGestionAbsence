package com.absenceManager.ensah.Models;


import com.absenceManager.ensah.Entity.Inscription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ModelInscription {
    private int idInscription;
    private int annee;
    private int etat;
    private ModelEtudiant etudiant;
    private ModelNiveau niveau;

    ModelInscription(Inscription inscription){
        this.idInscription = inscription.getIdInscription();
        this.annee = inscription.getAnnee();
        this.etat = inscription.getEtat();
        this.etudiant = new ModelEtudiant(inscription.getEtudiant());
        this.niveau = new ModelNiveau(inscription.getNiveau());
    }
}
