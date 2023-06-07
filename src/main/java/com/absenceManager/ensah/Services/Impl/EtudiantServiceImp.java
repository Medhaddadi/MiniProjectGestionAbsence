package com.absenceManager.ensah.Services.Impl;

import com.absenceManager.ensah.Entity.Etudiant;
import com.absenceManager.ensah.Models.ModelEtudiant;
import com.absenceManager.ensah.Repasatory.EtudiantRepository;
import com.absenceManager.ensah.Services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class EtudiantServiceImp implements EtudiantService {
    private final EtudiantRepository etudiantRepository;


    @Autowired
    public EtudiantServiceImp(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<ModelEtudiant> getAllEtudiants() {
        return etudiantRepository.getAll().stream().map(this::etudiantToModelEtudiant).collect(Collectors.toList());
    }

    @Override
    public void saveEtudiant(ModelEtudiant etudiant) {
        etudiantRepository.save(ModelEtudiantToEtudiant(etudiant));
    }

    @Override
    public List<ModelEtudiant> getAllEtudiantByKeySearch(String search) {
        return etudiantRepository.findAllByKeySearch(search).stream().map(this::etudiantToModelEtudiant).collect(Collectors.toList());
    }

    @Override
    public void deleteEtudiant(Long id) {

        Etudiant etudiant = etudiantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid etudiant Id:" + id));
        etudiant.setDeletedAt(LocalDateTime.now());
        etudiantRepository.save(etudiant);

    }


    @Override
    public void updateEtudiant(Etudiant etudiant) {
        etudiantRepository.save(etudiant);
    }

    @Override
    public ModelEtudiant getEtudiantById(Long id) {
        return etudiantToModelEtudiant(etudiantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid etudiant Id:" + id)));
    }

    @Override
    public List<ModelEtudiant> searchByCne(String cne) {
        return etudiantRepository.findAllByCne(cne).stream().map(this::etudiantToModelEtudiant).collect(Collectors.toList());
    }

    @Override
    public List<ModelEtudiant> searchByPnom(String pnom) {
        return etudiantRepository.findAllByPnom(pnom).stream().map(this::etudiantToModelEtudiant).collect(Collectors.toList());
    }

    @Override
    public List<ModelEtudiant> searchByNom(String nom) {
        return etudiantRepository.findAllByNom(nom).stream().map(this::etudiantToModelEtudiant).collect(Collectors.toList());
    }

    @Override
    public List<ModelEtudiant> findByClasse(String classe) {
        return etudiantRepository.findByClasse(classe).stream().map(this::etudiantToModelEtudiant).collect(Collectors.toList());
    }

    private Etudiant ModelEtudiantToEtudiant(ModelEtudiant etudiant)  {
        return  Etudiant.builder()
                .id(etudiant.getId())
                .nom(etudiant.getNom())
                .prenom(etudiant.getPrenom())
                .email(etudiant.getEmail())
                .identifiant(etudiant.getIdentifiant())
                .nomArabe(etudiant.getNomArabe())
                .prenomArabe(etudiant.getPrenomArabe())
                .photo(etudiant.getPhoto())
                .cne(etudiant.getCne())
                .dateNaissance(etudiant.getDateNaissance())
                .telephone(etudiant.getTelephone())
                .build();
    }

    private ModelEtudiant etudiantToModelEtudiant(Etudiant etudiant) {
        return ModelEtudiant.builder()
                .id(etudiant.getId())
                .nom(etudiant.getNom())
                .prenom(etudiant.getPrenom())
                .email(etudiant.getEmail())
                .identifiant(etudiant.getIdentifiant())
                .nomArabe(etudiant.getNomArabe())
                .prenomArabe(etudiant.getPrenomArabe())
                .photo(etudiant.getPhoto())
                .cne(etudiant.getCne())
                .dateNaissance(etudiant.getDateNaissance().toString())
                .telephone(etudiant.getTelephone())
                .build();
    }
}
