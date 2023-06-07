package com.absenceManager.ensah.Entity;

import groovy.transform.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean enabled=false;
    private boolean accountNotExpired=true;
    private boolean accountNotLocked=true;
    private String login;
    private String password;
    private boolean disconnectAccount = false;
    private boolean accepteDemandeAutorisationAbsence = true;
    private boolean affichePhoto;
    private boolean afficheEmail;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @OneToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur proprietaire;

    @ManyToOne
    @JoinColumn(name = "id_role" )
    private Role role;
}
