package com.absenceManager.ensah.Controllers;

import com.absenceManager.ensah.Services.CompteService;
import com.absenceManager.ensah.Services.RoleService;
import com.absenceManager.ensah.Services.UtilisateurService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.stereotype.Controller;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class GestionsCompteControllerTest {

    @Mock
    private UtilisateurService utilisateurService;

    @Mock
    private CompteService compteService;

    @Mock
    private RoleService roleService;

    @InjectMocks
    private Controller controller;

    @Test
    void testChoisirCompte() {
    }
}
