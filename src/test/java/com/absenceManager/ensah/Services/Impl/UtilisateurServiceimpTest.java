package com.absenceManager.ensah.Services.Impl;

import com.absenceManager.ensah.Models.ModelUtilisateur;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UtilisateurServiceimpTest {

    @Autowired
    private UtilisateurServiceimp utilisateurServiceimp;

    @Test
    void utilsteurToModelUtilisateur() {


    }

    @Test
    void modelUtilisateurToUtilisateur() {
    }

    @Test
    void getUtilisateur() {
        //get user with id 20
        ModelUtilisateur m = utilisateurServiceimp.getUtilisateur(20);
        System.out.println(m);
    }

    @Test
    void getAllUtilisateurs() {
        //get all users
        utilisateurServiceimp.getAllUtilisateurs().forEach(System.out::println);
    }


}