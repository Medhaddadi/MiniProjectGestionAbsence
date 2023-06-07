package com.absenceManager.ensah.Services;

import com.absenceManager.ensah.Models.ModelFiliere;
import java.util.List;
public interface FiliereService {

    void saveFiliere(ModelFiliere filiere);

    ModelFiliere getFiliereById(long l);

    void deleteFiliere(long l);

    List<ModelFiliere> getAllFiliere();

    List<ModelFiliere> searchFiliere(String query);

}
