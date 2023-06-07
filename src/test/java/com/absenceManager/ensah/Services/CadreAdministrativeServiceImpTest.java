package com.absenceManager.ensah.Services;

import com.absenceManager.ensah.Models.ModelCadreAdministrative;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CadreAdministrativeServiceImpTest {

    @Autowired
    CadreAdministrativeService cadreAdministrativeService;
    @Test
    void save() {
        Faker faker = new Faker();
        //create 5 faker cadreAdministrative
        for (int i = 0; i < 5; i++) {
            ModelCadreAdministrative cadreAdministrativeM = ModelCadreAdministrative.builder()
                    .nom(faker.name().firstName())
                    .prenom(faker.name().lastName())
                    .email(faker.internet().emailAddress())
                    .identifiant(faker.name().username())
                    .nomArabe(faker.name().firstName())
                    .prenomArabe(faker.name().lastName())
                    .photo(faker.internet().url())
                    .telephone(faker.phoneNumber().cellPhone())
                    .grade(faker.job().position())
                    .build();
            cadreAdministrativeService.save(cadreAdministrativeM);
        }
    }


    @Test
    void getAllCadreAdministratives() {
        List<ModelCadreAdministrative> cadreAdministrativeList=  cadreAdministrativeService.getAllCadreAdministratives();
        System.out.println(cadreAdministrativeList);
    }
}