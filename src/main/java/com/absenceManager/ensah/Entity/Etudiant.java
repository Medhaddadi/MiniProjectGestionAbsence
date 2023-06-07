package com.absenceManager.ensah.Entity;

import com.absenceManager.ensah.Entity.Utilisateur;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder

public class Etudiant extends Utilisateur {
    private String cne;
    private String classe;
    private String dateNaissance;

    // has many inscriptions
   @OneToMany(mappedBy = "etudiant")
    List<Inscription> inscriptions;
}
