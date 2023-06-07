package com.absenceManager.ensah.Models;

import com.absenceManager.ensah.Entity.Module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ModelModule {


        private int idModule;
        private String nom;
        private String code;
        private ModelNiveau niveau;

        private List<ModelMatiere> matieres;

        public ModelModule(Module module) {
            this.idModule = module.getIdModule();
            this.nom = module.getTitre();
            this.code = module.getCode();
            this.niveau = new ModelNiveau(module.getNiveau());
            this.matieres = module.getMatieres().stream().map(ModelMatiere::new).collect(java.util.stream.Collectors.toList());

        }
}
