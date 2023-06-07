package com.absenceManager.ensah.Entity;

import com.absenceManager.ensah.Models.ModelNiveau;
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
public class Niveau {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNiveau;
    private String alias;
    private String titre;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    public Niveau(ModelNiveau niveau) {
        this.idNiveau = niveau.getIdNiveau();
        this.alias = niveau.getAlias();
        this.titre = niveau.getTitre();
        this.filiere = new Filiere(niveau.getFiliere());
        this.modules = niveau.getModelModeles().stream().map(Module::new).collect(java.util.stream.Collectors.toList());
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
    //modules
    @OneToMany(mappedBy = "niveau")
    private List<Module> modules;

    @ManyToOne
    private Filiere filiere;

    //has many inscriptions
    @OneToMany(mappedBy = "niveau")
    private List<Inscription> inscriptions;
}
