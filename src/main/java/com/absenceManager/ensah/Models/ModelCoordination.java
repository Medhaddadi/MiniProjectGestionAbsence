package com.absenceManager.ensah.Models;

import com.absenceManager.ensah.Entity.Coordination;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ModelCoordination {

    private int idCoordination;
    private String dateDebut;
    private String dateFin;
    private ModelFiliere filiere;
    private ModelEnseignant coordonateur;

    public ModelCoordination(Coordination coordination) {
        this.idCoordination = coordination.getIdCoordination();
        this.dateDebut = coordination.getDateDebut();
        this.dateFin = coordination.getDateFin();
        this.filiere = new ModelFiliere(coordination.getFiliere());
    }
}
