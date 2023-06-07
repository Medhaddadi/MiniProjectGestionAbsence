package com.absenceManager.ensah.Entity;

import com.absenceManager.ensah.Entity.Utilisateur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.catalina.LifecycleState;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@SuperBuilder
public class Enseignant extends Utilisateur {
    private String specialite;


    @OneToMany
    private List<Coordination>  coordinations;

}
