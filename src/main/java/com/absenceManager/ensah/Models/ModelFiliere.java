package com.absenceManager.ensah.Models;

import com.absenceManager.ensah.Entity.Coordination;
import com.absenceManager.ensah.Entity.Filiere;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ModelFiliere {
    private Long idFiliere;
    private String titreFiliere;
    private String codeFiliere;
    private int anneeaccreditation;
    private int anneeFinaccreditation;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private List<ModelNiveau> niveaux;

    //has many coordinations
    @OneToMany(mappedBy = "filiere")
    private List<ModelCoordination> coordinations;

    public ModelFiliere(Filiere filiere) {
        this.idFiliere = filiere.getIdFiliere();
        this.titreFiliere = filiere.getTitreFiliere();
        this.codeFiliere = filiere.getCodeFiliere();
        this.anneeaccreditation = filiere.getAnneeaccreditation();
        this.anneeFinaccreditation = filiere.getAnneeFinaccreditation();
        this.createdAt = filiere.getCreatedAt();
        this.updatedAt = filiere.getUpdatedAt();
        this.deletedAt = filiere.getDeletedAt();
        niveaux =filiere.getNiveaux().stream().map(ModelNiveau::new).toList();
        this.coordinations = filiere.getCoordinations().stream().map(ModelCoordination::new).toList();
    }
}
