package com.absenceManager.ensah.Services;

import com.absenceManager.ensah.Models.ModelEtudiant;
import com.github.javafaker.Faker;
import jdk.dynalink.linker.LinkerServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EtudiantServiceTest {

    @Autowired
    private EtudiantService etudiantService;

    @Test
    void getAllEtudiants() {
        List<ModelEtudiant> etudiants = etudiantService.getAllEtudiants();
        System.out.println(etudiants.toString());
    }

    @Test
    void searchEtudiant() {
        List<ModelEtudiant> etudiants = etudiantService.getAllEtudiantByKeySearch("");
        System.out.println(etudiants.toString());
    }

    @Test
    void testGetAllEtudiants() {
    }

    @Test
    void saveEtudiant() {

        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            ModelEtudiant etudiant = new ModelEtudiant();
            etudiant.setCne(faker.number().digits(10));
            etudiant.setNom(faker.name().lastName());
            etudiant.setPrenom(faker.name().firstName());
            etudiant.setClasse(faker.number().digits(2));
            etudiant.setTelephone(faker.phoneNumber().cellPhone());
            etudiant.setEmail(faker.internet().emailAddress());
            etudiant.setClasse(faker.number().digits(2));
            etudiant.setNomArabe(faker.name().lastName());
            etudiant.setPrenomArabe(faker.name().firstName());
            etudiant.setIdentifiant(faker.name().username());
            etudiant.setPhoto(faker.internet().image());
            etudiant.setDateNaissance(faker.date().birthday().toString());
            etudiantService.saveEtudiant(etudiant);

        }
    }

    @Test
    void getAllEtudiantByKeySearch() {
    }

    @Test
    void deleteEtudiant() {
    }

    @Test
    void getAllByClasse() {
    }

    @Test
    void updateEtudiant() {
    }

    @Test
    void getEtudiantById() {
    }

    @Test
    void searchByCne() {
    }

    @Test
    void searchByPnom() {
    }

    @Test
    void searchByNom() {
    }
}