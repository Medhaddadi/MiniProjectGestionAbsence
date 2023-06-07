package com.absenceManager.ensah.Controllers;

import com.absenceManager.ensah.Entity.Coordination;
import com.absenceManager.ensah.Models.ModelFiliere;
import com.absenceManager.ensah.Services.CoordinationService;
import com.absenceManager.ensah.Services.FiliereService;
import com.absenceManager.ensah.Services.Impl.FiliereServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/filieres")
public class FiliereController {
    @Autowired
    private FiliereService filiereService;


    @Autowired
    private CoordinationService coordinationService;
    //create filiere
    @GetMapping("/create")
    public String createFiliere(Model model){
        model.addAttribute("filiere",new ModelFiliere());
        model.addAttribute("coordinations",coordinationService.getAllCoordination());
        return "filiere/create";
    }

    @PostMapping("/create")
    public String createFiliere(@ModelAttribute("filiere") ModelFiliere filiere, Model model, RedirectAttributes redirectAttributes , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "filiere/create";
        }
        redirectAttributes.addFlashAttribute("message","Filiere ajouté avec succès.");
        filiereService.saveFiliere(filiere);
        return "redirect:/filieres/create";
    }
    //show filiere
    @GetMapping("/show/{id}")
    public String showFiliere(Model model, @PathVariable String id){
        model.addAttribute("filiere",filiereService.getFiliereById(Long.parseLong(id)));
        return "filiere/show";
    }

    //update filiere
    @GetMapping("/update/{id}")
    public String updateFiliere(Model model, @PathVariable String id){
        model.addAttribute("filiere",filiereService.getFiliereById(Long.parseLong(id)));
        return "filiere/create";
    }

    @PostMapping("/update/{id}")
    public String updateFiliere(@ModelAttribute("filiere") ModelFiliere filiere, Model model, RedirectAttributes redirectAttributes , BindingResult bindingResult, @PathVariable String id){
        if (bindingResult.hasErrors()) {
            return "filiere/create";
        }
        filiere.setIdFiliere(Long.parseLong(id));
        redirectAttributes.addFlashAttribute("message","Filiere modifié avec succès.");
        filiereService.saveFiliere(filiere);
        return "redirect:/filiere/update/"+id;
    }


    //delete filiere
    @GetMapping("/delete/{id}")
    public String deleteFiliere(Model model, @PathVariable String id, RedirectAttributes redirectAttributes){
        filiereService.deleteFiliere(Long.parseLong(id));
        redirectAttributes.addFlashAttribute("message","Filiere supprimé avec succès.");
        return "redirect:/filieres";
    }


    //list filiere
    @GetMapping
    public String listFiliere(Model model){
        model.addAttribute("filieres",filiereService.getAllFiliere());
        return "filiere/index";
    }

    // searsh by all query
    @GetMapping("/search")
    public String searchFiliere(Model model, @RequestParam("query") String query){
        model.addAttribute("filieres",filiereService.searchFiliere(query));
        return "filiere/index";
    }


}
