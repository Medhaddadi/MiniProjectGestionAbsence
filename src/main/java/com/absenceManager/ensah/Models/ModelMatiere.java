package com.absenceManager.ensah.Models;

import com.absenceManager.ensah.Entity.Matiere;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

@ToString
public class ModelMatiere {

    private int idMatiere;
    private String nom;
    private String code;
    private ModelModule module;

    private List<ModelAbsence> absences;

    //creta constructor from matiere
    ModelMatiere(Matiere matiere) {
        this.idMatiere = matiere.getIdMatiere();
        this.nom = matiere.getNom();
        this.code = matiere.getCode();
        this.module = new ModelModule(matiere.getModule());
        this.absences = matiere.getAbsences().stream().map(ModelAbsence::new).collect(java.util.stream.Collectors.toList());
    }

}
