package com.absenceManager.ensah.Models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@ToString(callSuper = true)
public class ModelCadreAdministrative extends ModelUtilisateur{
    private String grade;
}
