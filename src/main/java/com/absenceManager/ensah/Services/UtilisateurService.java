package com.absenceManager.ensah.Services;

import com.absenceManager.ensah.Models.ModelUtilisateur;

import java.util.List;

public interface UtilisateurService {
    ModelUtilisateur getUtilisateur(long l);

    List<ModelUtilisateur> getAllUtilisateurs();

    List<ModelUtilisateur> getAllCadreAdministrativeByKeySearch(String search);
}
