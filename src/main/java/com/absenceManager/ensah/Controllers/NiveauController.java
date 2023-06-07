package com.absenceManager.ensah.Controllers;

import com.absenceManager.ensah.Models.ModelNiveau;
import com.absenceManager.ensah.Services.FiliereService;
import com.absenceManager.ensah.Services.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/niveaux")
public class NiveauController {

    @Autowired
    private NiveauService niveauService;

    @Autowired
    private FiliereService filiereService;

    @GetMapping
    public String showAllNiveau(Model model) {
        model.addAttribute("niveaux", niveauService.getAllNiveau());
        return "Niveau/index";
    }

    // create a new Niveau
    @GetMapping("/create")
    public String createNiveau(Model model) {
        model.addAttribute("filieres", filiereService.getAllFiliere());
        model.addAttribute("niveau", new ModelNiveau());
        return "Niveau/create";
    }

    @PostMapping("/create")
    public String createNiveau( RedirectAttributes redirectAttributes, @RequestParam("filiereId") String filiereID , @RequestParam("titre") String titre, @RequestParam("alias")String alias) {
        ModelNiveau niveau = new ModelNiveau();
        niveau.setTitre(titre);
        niveau.setAlias(alias);
        niveau.setFiliere(filiereService.getFiliereById(Long.parseLong(filiereID)));
        niveauService.createNiveau(niveau);
        redirectAttributes.addFlashAttribute("message", "Niveau created successfully");

        return "redirect:/niveaux";
    }


    @GetMapping("/update")
    public String updateNiveau(Model model) {
        model.addAttribute("niveau", new ModelNiveau());
        model.addAttribute("filieres", filiereService.getAllFiliere());
        return "Niveau/create";
    }

    @PostMapping("/update")
    public String updateNiveau(ModelNiveau niveau, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Niveau/create";
        }
        redirectAttributes.addFlashAttribute("message", "Niveau updated successfully");
        niveauService.createNiveau(niveau);
        return "redirect:/niveaux";
    }

    // delete
    @GetMapping("/delete/{id}")
    public String deleteNiveau(Model model, @PathVariable String id, RedirectAttributes redirectAttributes) {
        niveauService.deleteNiveau(Long.parseLong(id));
        redirectAttributes.addFlashAttribute("message", "Niveau deleted successfully");
        return "redirect:/niveaux";
    }



    @GetMapping("/search")
    public String searchNiveau(Model model, @RequestParam("query") String query) {
        model.addAttribute("niveaux", niveauService.searchNiveau(query));
        return "Niveau/index";
    }


}
