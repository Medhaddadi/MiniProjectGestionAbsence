package com.absenceManager.ensah.Models;

import com.absenceManager.ensah.Entity.Niveau;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelNiveau {
    private int idNiveau;
    private String titre;
    private String alias;

    private List<ModelModule> modelModeles;
    private List<ModelInscription> modelInscriptions;
    private ModelFiliere filiere;


    public ModelNiveau(Niveau niveau) {
        this.idNiveau = niveau.getIdNiveau();
        this.titre = niveau.getTitre();
        this.alias = niveau.getAlias();

        if (niveau.getModules()!= null)
            this.modelModeles = niveau.getModules().stream().map(ModelModule::new).collect(Collectors.toList());

        this.modelInscriptions = niveau.getInscriptions().stream().map(ModelInscription::new).collect(Collectors.toList());

        this.filiere = new ModelFiliere(niveau.getFiliere());
    }
}
