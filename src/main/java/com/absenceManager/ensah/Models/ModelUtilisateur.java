package com.absenceManager.ensah.Models;

import com.absenceManager.ensah.Entity.Compte;
import com.absenceManager.ensah.Entity.Etudiant;
import com.absenceManager.ensah.Entity.Utilisateur;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@ToString
public class ModelUtilisateur {
    private Long id;
    private String nom;
    private String prenom;
    private String identifiant;
    private String email;
    private String telephone;
    private String nomArabe;
    private String prenomArabe;
    private String photo;
    private ModelCompte compte;

    public ModelUtilisateur(Utilisateur etudiant) {
        this.id = etudiant.getId();
        this.nom = etudiant.getNom();
        this.prenom = etudiant.getPrenom();
        this.identifiant = etudiant.getIdentifiant();
        this.email = etudiant.getEmail();
        this.telephone = etudiant.getTelephone();
        this.nomArabe = etudiant.getNomArabe();
        this.prenomArabe = etudiant.getPrenomArabe();
        this.photo = etudiant.getPhoto();
        this.compte = new ModelCompte(etudiant.getCompte());
    }

    //create ModelUtilisateur from ModelEtudiant
    public ModelUtilisateur(ModelEnseignant etudiant) {
        this.id = etudiant.getId();
        this.nom = etudiant.getNom();
        this.prenom = etudiant.getPrenom();
        this.identifiant = etudiant.getIdentifiant();
        this.email = etudiant.getEmail();
        this.telephone = etudiant.getTelephone();
        this.nomArabe = etudiant.getNomArabe();
        this.prenomArabe = etudiant.getPrenomArabe();
        this.photo = etudiant.getPhoto();
        this.compte = new ModelCompte(etudiant.getCompte());
    }

}
