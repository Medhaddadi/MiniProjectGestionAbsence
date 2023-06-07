package com.absenceManager.ensah.Models;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
public class ModelEnseignant extends ModelUtilisateur  {
    private String specialite;

    // creta constructor from enseignant
    public ModelEnseignant(ModelEnseignant utilisateur) {

        this.specialite = utilisateur.getSpecialite();

    }
}
