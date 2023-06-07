package com.absenceManager.ensah.Repasatory.UtilisateurRepository;

import com.absenceManager.ensah.Entity.Utilisateur;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UtilisateurRepositoryTest {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Test
    void getAllUsers() {
        //get all users
        List<Utilisateur> et = utilisateurRepository.findAll();
        for (Utilisateur utilisateur : et) {
            System.out.println(utilisateur);
        }
    }

}