package com.absenceManager.ensah.Models;

import com.absenceManager.ensah.Entity.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ModelRole {

    private Long idRole;
    @NotNull
    @Size(min = 2, max = 50, message = "Role name must be between 2 and 50 characters")
    private String nomRole;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private List<ModelCompte> comptes;

    ModelRole ( Role role ) {
        this.idRole = role.getId();
        this.nomRole = role.getNom();
        this.createdAt = role.getCreatedAt();
        this.updatedAt = role.getUpdatedAt();
        this.deletedAt = role.getDeletedAt();
        this.comptes = role.getComptes().stream().map(ModelCompte::new).toList();
    }

}
