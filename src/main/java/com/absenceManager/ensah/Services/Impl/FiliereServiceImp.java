package com.absenceManager.ensah.Services.Impl;

import com.absenceManager.ensah.Entity.Filiere;
import com.absenceManager.ensah.Models.ModelFiliere;
import com.absenceManager.ensah.Repasatory.FiliereRepository;
import com.absenceManager.ensah.Services.FiliereService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereServiceImp implements FiliereService {
    @Autowired
    private FiliereRepository filiereRepository;
    @Override
    public void saveFiliere(ModelFiliere filiere) {
        filiereRepository.save(new Filiere(filiere));
    }

    @Override
    public ModelFiliere getFiliereById(long l) {
        return new ModelFiliere(filiereRepository.findByIdWhereDeleteAtNull(l));
    }

    @Override
    public void deleteFiliere(long l) {
        Filiere filiere = filiereRepository.findByIdWhereDeleteAtNull(l);
        filiere.getNiveaux().forEach(niveau -> {
            niveau.setDeletedAt(java.time.LocalDateTime.now());
        });
        filiere.setDeletedAt(java.time.LocalDateTime.now());
        filiere.getCoordinations().forEach(coordination -> {
            coordination.setDeletedAt(java.time.LocalDateTime.now());
        });
        filiereRepository.save(filiere);
    }

    @Override
    public List<ModelFiliere> getAllFiliere() {
        return filiereRepository.findAllWhereDeleteAtNull().stream().map(ModelFiliere::new).toList();
    }

    @Override
    public List<ModelFiliere> searchFiliere(String query) {
        return filiereRepository.findAllWhereDeleteAtNullAndNomContains(query).stream().map(ModelFiliere::new).toList();
    }


}
