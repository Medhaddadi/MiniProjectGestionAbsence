package com.absenceManager.ensah.Entity;

import com.absenceManager.ensah.Models.ModelFiliere;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder

public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFiliere;
    private String titreFiliere;
    private String codeFiliere;
    private int anneeaccreditation;
    private int anneeFinaccreditation;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    public Filiere(ModelFiliere filiere) {
        this.idFiliere = filiere.getIdFiliere();
        this.titreFiliere = filiere.getTitreFiliere();
        this.codeFiliere = filiere.getCodeFiliere();
        this.anneeaccreditation = filiere.getAnneeaccreditation();
        this.anneeFinaccreditation = filiere.getAnneeFinaccreditation();
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    //0..*
    //niveaux
    @OneToMany(mappedBy = "filiere")
    private List<Niveau> niveaux;

    //has many coordinations
    @OneToMany(mappedBy = "filiere")
    private List<Coordination> coordinations;
}
