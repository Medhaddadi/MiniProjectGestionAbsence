package com.absenceManager.ensah.Services.Impl;

import com.absenceManager.ensah.Entity.Utilisateur;
import com.absenceManager.ensah.Models.ModelUtilisateur;
import com.absenceManager.ensah.Repasatory.CompteRepository;
import com.absenceManager.ensah.Repasatory.RoleRepository;
import com.absenceManager.ensah.Repasatory.UtilisateurRepository.UtilisateurRepository;
import com.absenceManager.ensah.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UtilisateurServiceimp implements UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;


    public static ModelUtilisateur UtilsteurToModelUtilisateur(Utilisateur utilisateur) {
        return ModelUtilisateur.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .identifiant(utilisateur.getIdentifiant())
                .telephone(utilisateur.getTelephone())
                .nomArabe(utilisateur.getNomArabe())
                .prenomArabe(utilisateur.getPrenomArabe())
                .photo(utilisateur.getPhoto())
                .build();
    }

    public static Utilisateur ModelUtilisateurToUtilisateur(ModelUtilisateur modelUtilisateur){
        return Utilisateur.builder()
                .id(modelUtilisateur.getId())
                .nom(modelUtilisateur.getNom())
                .prenom(modelUtilisateur.getPrenom())
                .email(modelUtilisateur.getEmail())
                .identifiant(modelUtilisateur.getIdentifiant())
                .telephone(modelUtilisateur.getTelephone())
                .nomArabe(modelUtilisateur.getNomArabe())
                .prenomArabe(modelUtilisateur.getPrenomArabe())
                .photo(modelUtilisateur.getPhoto())
                .build();
    }

    @Override
    public ModelUtilisateur getUtilisateur(long l) {
        return UtilsteurToModelUtilisateur(utilisateurRepository.findById(l).get());
    }

    @Override
    public List<ModelUtilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll().stream().map(UtilisateurServiceimp::UtilsteurToModelUtilisateur).toList();
    }

    @Override
    public List<ModelUtilisateur> getAllCadreAdministrativeByKeySearch(String search) {
        return utilisateurRepository.findAllByKeySearch(search).stream().map(UtilisateurServiceimp::UtilsteurToModelUtilisateur).toList();
    }

}
