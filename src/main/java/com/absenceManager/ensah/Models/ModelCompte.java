package com.absenceManager.ensah.Models;

import com.absenceManager.ensah.Entity.Compte;
import com.absenceManager.ensah.Entity.Role;
import com.absenceManager.ensah.Entity.Utilisateur;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ModelCompte {
    private Long id;
    private boolean enabled;
    private boolean accountNotExpired;
    private boolean accountNotLocked;
    private String login;
    private String password;
    private boolean disconnectAccount;
    private boolean accepteDemandeAutorisationAbsence;
    private boolean affichePhoto;
    private boolean afficheEmail;
    private ModelUtilisateur proprietaire;
    private ModelRole role;

    public ModelCompte(Compte compte) {
        this.id = compte.getId();
        this.enabled = compte.isEnabled();
        this.accountNotExpired = compte.isAccountNotExpired();
        this.accountNotLocked = compte.isAccountNotLocked();
        this.login = compte.getLogin();
        this.password = compte.getPassword();
        this.disconnectAccount = compte.isDisconnectAccount();
        this.accepteDemandeAutorisationAbsence = compte.isAccepteDemandeAutorisationAbsence();
        this.affichePhoto = compte.isAffichePhoto();
        this.afficheEmail = compte.isAfficheEmail();
        this.proprietaire = new ModelUtilisateur(compte.getProprietaire());
        this.role = new ModelRole(compte.getRole());
    }

    public ModelCompte(ModelCompte compte) {
    }
}
