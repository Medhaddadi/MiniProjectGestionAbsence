package com.absenceManager.ensah.Models;

import com.absenceManager.ensah.Entity.Etudiant;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class ModelEtudiant extends ModelUtilisateur {
    private String cne;

    private String dateNaissance;

    private String classe;

    public ModelEtudiant(Etudiant etudiant) {
        super(etudiant);
        this.cne = etudiant.getCne();
        this.dateNaissance = etudiant.getDateNaissance();
        this.classe = etudiant.getClasse();
    }
}
