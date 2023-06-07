package com.absenceManager.ensah.Entity;

import com.absenceManager.ensah.Models.ModelMatiere;
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
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idMatiere;
    private String nom;
    private String code;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    public Matiere(ModelMatiere modelMatiere) {
        this.idMatiere = modelMatiere.getIdMatiere();
        this.nom = modelMatiere.getNom();
        this.code = modelMatiere.getCode();
        this.module = new Module(modelMatiere.getModule());
        this.absences = modelMatiere.getAbsences().stream().map(Absence::new).collect(java.util.stream.Collectors.toList());
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @ManyToOne
    private Module module;

    //has many absences
    @OneToMany(mappedBy = "matiere")
    private List<Absence> absences;


}
