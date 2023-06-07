package com.absenceManager.ensah.Services;

import com.absenceManager.ensah.Entity.Compte;
import com.absenceManager.ensah.Entity.Enseignant;
import com.absenceManager.ensah.Models.ModelCompte;
import com.absenceManager.ensah.Models.ModelEnseignant;

import java.util.List;


public interface EnseignantService {
    void save(ModelEnseignant modelEnseignant);

    Enseignant modelEnseignantToEnseignant(ModelEnseignant modelEnseignant);

    ModelEnseignant enseignantToModelEnseignant(Enseignant enseignant);

    void delete(ModelEnseignant modelEnseignant);

    void update(ModelEnseignant modelEnseignant);

    ModelEnseignant getEnseignantById(String id);

    ModelEnseignant getEnseignantByCompte(Compte compte);

    ModelEnseignant getEnseignantByCompteM(ModelCompte modelCompte);

    List<ModelEnseignant> getAllEnseignants();

    List<ModelEnseignant> getAllEnseignantByKeySearch(String search);
}
