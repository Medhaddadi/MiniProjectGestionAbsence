package com.absenceManager.ensah.Entity;

import com.absenceManager.ensah.Models.ModelModule;
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
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModule;
    private String titre;
    private String code;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    public Module(ModelModule modelModule) {
        this.idModule = modelModule.getIdModule();
        this.titre = modelModule.getNom();
        this.code = modelModule.getCode();
        this.niveau = new Niveau(modelModule.getNiveau());
        this.matieres = modelModule.getMatieres().stream().map(Matiere::new).collect(java.util.stream.Collectors.toList());

    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "module")
    private List<Matiere> matieres;

    @ManyToOne
    private Niveau niveau;
}
