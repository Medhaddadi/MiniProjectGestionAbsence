package com.absenceManager.ensah.Services.Impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CompteServiceImpTest {

    @Autowired
    private CompteServiceImp compteServiceImp;
    @Test
    void getAllComptesLogin() {
        System.out.println(compteServiceImp.getAllComptesLogin());
    }

}