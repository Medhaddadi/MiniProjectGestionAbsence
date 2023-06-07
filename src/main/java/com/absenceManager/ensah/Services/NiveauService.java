package com.absenceManager.ensah.Services;

import com.absenceManager.ensah.Models.ModelNiveau;

import java.util.List;

public interface NiveauService {
    List<ModelNiveau> getAllNiveau();

    void createNiveau(ModelNiveau niveau);

    void deleteNiveau(long l);

    List<ModelNiveau> searchNiveau(String query);
}
