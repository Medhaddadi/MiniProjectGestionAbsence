package com.absenceManager.ensah.Services;

import com.absenceManager.ensah.Entity.CadreAdministrateur;
import com.absenceManager.ensah.Models.ModelCadreAdministrative;

import java.util.List;


public interface CadreAdministrativeService {
    void save(ModelCadreAdministrative modelCadreAdministrative);

    CadreAdministrateur modelCadreAdministrativeToCadreAdministrative(ModelCadreAdministrative modelCadreAdministrative);

    ModelCadreAdministrative cadreAdministrativeToModelCadreAdministrative(CadreAdministrateur cadreAdministrative);

    List<ModelCadreAdministrative> getAllCadreAdministratives();

}
