package com.absenceManager.ensah.Services;

import com.absenceManager.ensah.Models.ModelEnseignant;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EnseignantServiceImpTest {

    @Autowired
    EnseignantService enseignantService;

    @Test
    void save() {
        Faker faker = new Faker();
        //create 10 faker enseignant
        for (int i = 0; i < 10; i++) {
            ModelEnseignant enseignantM = ModelEnseignant.builder()
                    .nom(faker.name().firstName())
                    .prenom(faker.name().lastName())
                    .email(faker.internet().emailAddress())
                    .identifiant(faker.name().username())
                    .nomArabe(faker.name().firstName())
                    .prenomArabe(faker.name().lastName())
                    .photo(faker.internet().url())
                    .specialite(faker.job().field())
                    .telephone(faker.phoneNumber().cellPhone())
                    .build();
            enseignantService.save(enseignantM);
        }
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void getEnseignantById() {
    }

    @Test
    void getEnseignantByCompte() {
    }

    @Test
    void getEnseignantByCompteM() {
    }

    @Test
    void getAllEnseignants() {
        List<ModelEnseignant> enseignants = enseignantService.getAllEnseignants();
        System.out.println(enseignants);
    }
    @Test
    void getAllEnseignantByKeySearch() {
        List<ModelEnseignant> enseignants = enseignantService.getAllEnseignantByKeySearch("araceli");
        System.out.println(enseignants);
    }
}