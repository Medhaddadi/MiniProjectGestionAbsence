package com.absenceManager.ensah.Services.Impl;

import com.absenceManager.ensah.Entity.CadreAdministrateur;
import com.absenceManager.ensah.Models.ModelCadreAdministrative;
import com.absenceManager.ensah.Repasatory.CadreAdministrateurRepository;
import com.absenceManager.ensah.Services.CadreAdministrativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CadreAdministrativeServiceImp implements CadreAdministrativeService {

    @Autowired
    private CadreAdministrateurRepository cadreAdministrativeService;

    @Override
    public void save(ModelCadreAdministrative modelCadreAdministrative) {
        cadreAdministrativeService.save(modelCadreAdministrativeToCadreAdministrative(modelCadreAdministrative));
    }

    @Override
    public CadreAdministrateur modelCadreAdministrativeToCadreAdministrative(ModelCadreAdministrative modelCadreAdministrative) {
        return (CadreAdministrateur) CadreAdministrateur.builder()
                .id(modelCadreAdministrative.getId())
                .nom(modelCadreAdministrative.getNom())
                .prenom(modelCadreAdministrative.getPrenom())
                .identifiant(modelCadreAdministrative.getIdentifiant())
                .email(modelCadreAdministrative.getEmail())
                .telephone(modelCadreAdministrative.getTelephone())
                .nomArabe(modelCadreAdministrative.getNomArabe())
                .prenomArabe(modelCadreAdministrative.getPrenomArabe())
                .photo(modelCadreAdministrative.getPhoto())
                .grade(modelCadreAdministrative.getGrade())
                .build();
    }

    @Override
    public ModelCadreAdministrative cadreAdministrativeToModelCadreAdministrative(CadreAdministrateur cadreAdministrative) {
        return ModelCadreAdministrative.builder()
                .id(cadreAdministrative.getId())
                .nom(cadreAdministrative.getNom())
                .prenom(cadreAdministrative.getPrenom())
                .identifiant(cadreAdministrative.getIdentifiant())
                .email(cadreAdministrative.getEmail())
                .telephone(cadreAdministrative.getTelephone())
                .nomArabe(cadreAdministrative.getNomArabe())
                .prenomArabe(cadreAdministrative.getPrenomArabe())
                .photo(cadreAdministrative.getPhoto())
                .grade(cadreAdministrative.getGrade())
                .build();
    }

    @Override
    public List<ModelCadreAdministrative> getAllCadreAdministratives() {
        return cadreAdministrativeService.findAll().stream().map(this::cadreAdministrativeToModelCadreAdministrative).collect(Collectors.toList());
    }
}
