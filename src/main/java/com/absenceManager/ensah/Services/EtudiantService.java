package com.absenceManager.ensah.Services;

import com.absenceManager.ensah.Entity.Etudiant;
import com.absenceManager.ensah.Models.ModelEtudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;



public interface EtudiantService {
    List<ModelEtudiant> getAllEtudiants();

    void saveEtudiant(ModelEtudiant etudiant);

    List<ModelEtudiant> getAllEtudiantByKeySearch(String search);

    void deleteEtudiant(Long id);



    void updateEtudiant(Etudiant etudiant);

    ModelEtudiant getEtudiantById(Long id);

    List<ModelEtudiant> searchByCne(String cne);

    List<ModelEtudiant> searchByPnom(String pnom);

    List<ModelEtudiant> searchByNom(String nom);

    List<ModelEtudiant> findByClasse(String classe);
}
