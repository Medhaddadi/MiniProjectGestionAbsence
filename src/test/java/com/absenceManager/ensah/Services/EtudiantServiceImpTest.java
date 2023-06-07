package com.absenceManager.ensah.Services;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.absenceManager.ensah.Models.ModelEtudiant;
import com.github.javafaker.Faker;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EtudiantServiceImpTest {

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
    void getAllEtudiantByKeySearch() {
        List<ModelEtudiant> etudiants = etudiantService.getAllEtudiantByKeySearch("00");
        for (ModelEtudiant e : etudiants) {
            System.out.println(e);
        }
    }

    @Test
    void addEtudiants() throws ParseException {
        Faker faker = new Faker();
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
                    .telephone(faker.phoneNumber().cellPhone())
                    .build();
            etudiantService.saveEtudiant(m);
        }
    }
}