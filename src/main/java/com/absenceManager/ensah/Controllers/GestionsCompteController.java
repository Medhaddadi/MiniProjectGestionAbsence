package com.absenceManager.ensah.Controllers;

import com.absenceManager.ensah.Models.*;
import com.absenceManager.ensah.Services.*;
import com.absenceManager.ensah.helpers.CompteManagerHelper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/comptes")
public class GestionsCompteController {
    private final UtilisateurService utilisateurService;
    private final CompteService compteService;
    private final EnseignantService enseignantService;
    private final EtudiantService etudiantService;
    private final CadreAdministrativeService cadreAdministrativeService;
    private final RoleService roleService;
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(GestionsCompteController.class);


    @Autowired
    public GestionsCompteController(UtilisateurService utilisateurService, CompteService compteService, EnseignantService enseignantService, EtudiantService etudiantService, CadreAdministrativeService cadreAdministrativeService, RoleService roleService) {
        this.utilisateurService = utilisateurService;
        this.compteService = compteService;
        this.enseignantService = enseignantService;
        this.etudiantService = etudiantService;
        this.cadreAdministrativeService = cadreAdministrativeService;
        this.roleService = roleService;
    }

    @GetMapping("/choisirCompte")
    public String choisirCompte(Model model) {
        logger.info("choisirCompte");
        List<ModelUtilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
        model.addAttribute("utilisateurs", utilisateurs);
        logger.info("utilisateurs: " + utilisateurs);
        model.addAttribute("userType", "user");
        return "GestionsCompteView/choisirCompte";
    }

    @PostMapping("/search")
    public String search(@RequestParam(value = "search") String search, @RequestParam("userType") String userType, Model model) {
        if (userType.equals("Etudiant")) {
            List<ModelEtudiant> etudiants = etudiantService.getAllEtudiantByKeySearch(search);
            model.addAttribute("utilisateurs", etudiants);
        } else if (userType.equals("Enseignant")) {
            List<ModelEnseignant> enseignants = enseignantService.getAllEnseignantByKeySearch(search);
            model.addAttribute("utilisateurs", enseignants);
        } else {
            List<ModelUtilisateur> utilisateurs = utilisateurService.getAllCadreAdministrativeByKeySearch(search);
            model.addAttribute("utilisateurs", utilisateurs);
        }
        model.addAttribute("userType", userType);
        return "GestionsCompteView/choisirCompte";
    }


    @PostMapping("/creerCompte")
    public String creerCompte(@ModelAttribute("compte") ModelCompte compte) {
        logger.info("compte: " + compte);
        compteService.creerCompte(compte);
        return "redirect:/comptes";
    }

    @GetMapping("/")
    public String getComptes(Model model) {
        model.addAttribute("comptes", compteService.getAllComptes());
        return "gestionComptes";
    }

    @GetMapping("/deleteCompte")
    public String deleteCompte(@RequestParam("id") Long id) {
        compteService.deleteCompte(id);
        return "redirect:/comptes";
    }

    @GetMapping("/updateCompte")
    public String updateCompte(@RequestParam("id") Long id, Model model) {
        model.addAttribute("compte", compteService.getCompte(id));
        return "updateCompte";
    }

    @PostMapping("/updateCompte")
    public String updateCompte(@ModelAttribute("compte") ModelCompte compte) {
        compteService.updateCompte(compte);
        return "redirect:/comptes";
    }

}
