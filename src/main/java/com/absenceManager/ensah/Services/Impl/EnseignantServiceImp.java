package com.absenceManager.ensah.Services.Impl;

import com.absenceManager.ensah.Entity.Compte;
import com.absenceManager.ensah.Entity.Enseignant;
import com.absenceManager.ensah.Models.ModelCompte;
import com.absenceManager.ensah.Models.ModelEnseignant;
import com.absenceManager.ensah.Repasatory.EnseignantRepository;
import com.absenceManager.ensah.Services.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantServiceImp implements EnseignantService {

    @Autowired
    private EnseignantRepository    enseignantRepository;
    @Override
    public void save(ModelEnseignant modelEnseignant) {
        enseignantRepository.save(modelEnseignantToEnseignant(modelEnseignant));
    }

    @Override
    public Enseignant modelEnseignantToEnseignant(ModelEnseignant modelEnseignant) {
        return Enseignant.builder()
                .id(modelEnseignant.getId())
                .nom(modelEnseignant.getNom())
                .prenom(modelEnseignant.getPrenom())
                .email(modelEnseignant.getEmail())
                .identifiant(modelEnseignant.getIdentifiant())
                .nomArabe(modelEnseignant.getNomArabe())
                .prenomArabe(modelEnseignant.getPrenomArabe())
                .photo(modelEnseignant.getPhoto())
                .specialite(modelEnseignant.getSpecialite())
                .telephone(modelEnseignant.getTelephone())
                .build();
    }

    @Override
    public ModelEnseignant enseignantToModelEnseignant(Enseignant enseignant) {
        return ModelEnseignant.builder()
                .id(enseignant.getId())
                .nom(enseignant.getNom())
                .prenom(enseignant.getPrenom())
                .email(enseignant.getEmail())
                .identifiant(enseignant.getIdentifiant())
                .nomArabe(enseignant.getNomArabe())
                .prenomArabe(enseignant.getPrenomArabe())
                .photo(enseignant.getPhoto())
                .specialite(enseignant.getSpecialite())
                .telephone(enseignant.getTelephone())
                .build();
    }

    @Override
    public void delete(ModelEnseignant modelEnseignant) {

    }

    @Override
    public void update(ModelEnseignant modelEnseignant) {

    }

    @Override
    public ModelEnseignant getEnseignantById(String id) {
        return null;
    }

    @Override
    public ModelEnseignant getEnseignantByCompte(Compte compte) {
        return null;
    }

    @Override
    public ModelEnseignant getEnseignantByCompteM(ModelCompte modelCompte) {
        return null;
    }

    @Override
    public List<ModelEnseignant> getAllEnseignants() {
        return enseignantRepository.findAll().stream().map(this::enseignantToModelEnseignant).toList();
    }

    @Override
    public List<ModelEnseignant> getAllEnseignantByKeySearch(String search) {
        return enseignantRepository.getAllEnseignantByKeySearch(search).stream().map(this::enseignantToModelEnseignant).toList();
    }
}
