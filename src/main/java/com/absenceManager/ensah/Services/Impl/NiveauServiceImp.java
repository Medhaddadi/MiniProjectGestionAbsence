package com.absenceManager.ensah.Services.Impl;

import com.absenceManager.ensah.Entity.Niveau;
import com.absenceManager.ensah.Models.ModelNiveau;
import com.absenceManager.ensah.Repasatory.NiveauRepository;
import com.absenceManager.ensah.Services.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NiveauServiceImp implements NiveauService {
    @Autowired
    private NiveauRepository niveauRepository;

    @Override
    public List<ModelNiveau> getAllNiveau() {
        return niveauRepository.findAllWhereDeletedIsNull().stream().map(ModelNiveau::new).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public void createNiveau(ModelNiveau niveau) {
        Niveau newNiveau = new Niveau(niveau);

    }

    @Override
    public void deleteNiveau(long l) {
        Niveau niveau = niveauRepository.findById(l).get();
        niveau.setDeletedAt(LocalDateTime.now());
        niveau.getInscriptions().forEach(inscription -> {
            inscription.setDeletedAt(LocalDateTime.now());
        });
        niveau.getModules().forEach(module -> {
            module.setDeletedAt(LocalDateTime.now());
        });
        niveau.getInscriptions().forEach(inscription -> {
            inscription.setDeletedAt(LocalDateTime.now());
        });
        niveauRepository.save(niveau);
    }

    @Override
    public List<ModelNiveau> searchNiveau(String query) {
        return niveauRepository.findAllWhereDeletedIsNullAndQuery().stream().map(ModelNiveau::new).collect(java.util.stream.Collectors.toList());
    }
}
