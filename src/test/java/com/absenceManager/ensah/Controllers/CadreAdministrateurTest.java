package com.absenceManager.ensah.Controllers;

import com.absenceManager.ensah.Models.ModelEtudiant;
import com.absenceManager.ensah.Services.EtudiantService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CadreAdministrateurTest {

    @Autowired
    EtudiantService etudiantService;

    @Test
    void getAllEtudiants() {
        List<ModelEtudiant> etudiants = etudiantService.getAllEtudiants();
        for (ModelEtudiant e : etudiants) {
            System.out.println(e);
        }

    }

    @Test
    void addEtudiants() throws ParseException {
        Faker faker = new Faker();
        List<ModelEtudiant> etudiants = new ArrayList<>();
        //create 10 etudiants
        for (int i = 0; i < 10; i++) {
            ModelEtudiant m = ModelEtudiant.builder()
                    .id(faker.number().randomNumber())
                    .nom(faker.name().firstName())
                    .prenom(faker.name().lastName())
                    .email(faker.internet().emailAddress())
                    .identifiant(faker.name().username())
                    .nomArabe(faker.name().firstName())
                    .prenomArabe(faker.name().lastName())
                    .photo(faker.internet().image())
                    .cne(faker.number().digits(10))
                    .dateNaissance(faker.date().birthday().toString())
                    .telephone(faker.phoneNumber().cellPhone())
                    .build();
                etudiantService.saveEtudiant(m);
        }

    }
}