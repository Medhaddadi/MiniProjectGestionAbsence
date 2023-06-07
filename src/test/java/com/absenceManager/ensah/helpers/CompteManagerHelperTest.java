package com.absenceManager.ensah.helpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompteManagerHelperTest {

    @Test
    void test() {
        System.out.println(CompteManagerHelper.genarateLogin("nom", "prenom", null));
    }

}