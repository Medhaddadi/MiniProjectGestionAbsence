package com.absenceManager.ensah.Controllers;

import com.absenceManager.ensah.Entity.Etudiant;
import com.absenceManager.ensah.Models.ModelEtudiant;
import com.absenceManager.ensah.Services.EtudiantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.util.List;

@RequestMapping("/etudiants")
@Controller
public class EtudiantController {
    private final EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public String showEtudiants(Model model) {
        List<ModelEtudiant> etudiants = etudiantService.getAllEtudiants();
        model.addAttribute("etudiants", etudiants);
        return "Etudiant/etudiant-list";
    }


    @GetMapping("/ajouter")
    public String showAddEtudiantForm(Model model) {

        model.addAttribute("etudiant", new ModelEtudiant());
        return "Etudiant/etudiant-form";
    }

    // Save new student
    @PostMapping("/ajouter")
    public String addEtudiant(@Valid @ModelAttribute("etudiant") ModelEtudiant etudiant, BindingResult bindingResult, @RequestParam("dateNaissance") String dateNaissance, RedirectAttributes redirectAttributes) {
        // TODO : how to convert the date de naissance String to date from the mode etudiant


        if (bindingResult.hasErrors()) {
            return "Etudiant/etudiant-form";
        }

        redirectAttributes.addFlashAttribute("message", "Etudiant ajouté avec succès.");
        etudiantService.saveEtudiant(etudiant);

        return "redirect:/etudiants";
    }

    // ADD show student details
    @GetMapping("/details/{id}")
    public String showEtudiantDetails(@PathVariable("id") Long id, Model model) {
        ModelEtudiant etudiant = etudiantService.getEtudiantById(id);
        model.addAttribute("etudiant", etudiant);
        return "Etudiant/etudiant-details";
    }

    // Edit student form
    @GetMapping("/modifier/{id}")
    public String showEditEtudiantForm(@PathVariable("id") Long id, Model model) {
        ModelEtudiant etudiant = etudiantService.getEtudiantById(id);
        model.addAttribute("etudiant", etudiant);
        return "Etudiant/etudiant-form";
    }

    // Update student
    @PostMapping("/modifier/{id}")
    public String updateEtudiant(@PathVariable("id") Long id, @Valid @ModelAttribute("etudiant") Etudiant etudiant, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "Etudiant/etudiant-form";
        }
        etudiant.setId(id);
        etudiantService.updateEtudiant(etudiant);
        redirectAttributes.addFlashAttribute("message", "Etudiant modifié avec succès.");
        return "redirect:/etudiants";
    }

    // Delete student
    @GetMapping("/supprimer/{id}")
    public String deleteEtudiant(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        etudiantService.deleteEtudiant(id);
        redirectAttributes.addFlashAttribute("message", "Etudiant supprimé avec succès.");
        return "redirect:/etudiants";
    }

    // search mappping rechercher
    @GetMapping("/rechercher")
    public String searchEtudiant(@RequestParam(value = "nom", required = false) String nom,
                                 @RequestParam(value = "pnom", required = false) String pnom,
                                 @RequestParam(value = "cne", required = false) String cne,
                                 @RequestParam(value = "classe", required = false) String classe,
                                 Model model) {
        if (nom != null) {
            List<ModelEtudiant> etudiants = etudiantService.searchByNom(nom);
            model.addAttribute("etudiants", etudiants);
            return "Etudiant/etudiant-list";

        } else if (pnom != null) {
            List<ModelEtudiant> etudiants = etudiantService.searchByPnom(pnom);
            model.addAttribute("etudiants", etudiants);
            return "Etudiant/etudiant-list";

        } else if (cne != null) {
            List<ModelEtudiant> etudiants = etudiantService.searchByCne(cne);
            model.addAttribute("etudiants", etudiants);
            return "Etudiant/etudiant-list";

        } else if (classe != null) {
            List<ModelEtudiant> etudiants = etudiantService.findByClasse(classe);
            model.addAttribute("etudiants", etudiants);
            return "Etudiant/etudiant-list";

        }
        else
            return "redirect:/etudiants";

    }


}
