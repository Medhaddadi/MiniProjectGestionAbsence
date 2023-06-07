package com.absenceManager.ensah.Services;

import com.absenceManager.ensah.Entity.Compte;
import com.absenceManager.ensah.Models.ModelCompte;
import com.absenceManager.ensah.Models.ModelRole;

import java.util.List;
import java.util.Set;


public interface CompteService {

    public String addCompte(Long idRole, Long idUtilisateur);

    public void deleteCompte(Long id);

    public void updateCompte(ModelCompte compte);

    public Compte getCompte(Long id);

    List<ModelCompte> getAllComptes();

    void creerCompte(ModelCompte compte);

    List<String> getAllComptesLogin();
}
