package com.absenceManager.ensah.Controllers;

import com.absenceManager.ensah.Models.ModelRole;
import com.absenceManager.ensah.Services.RoleService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public String getAllRoles(Model model){
        model.addAttribute("roles", roleService.getAllRolesNotDeleted());
        return "Roles/index";
    }

    @GetMapping("/add")
    public String showAddRoleForm(Model model) {
        model.addAttribute("role", new ModelRole());
        return "Roles/create";
    }

    @PostMapping("/add")
    public String addRole(@Valid @ModelAttribute("role") ModelRole role, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "roles/create";
        }

        try {
            roleService.saveRole(role);
        } catch (DataIntegrityViolationException e) {
            result.rejectValue("nomRole", "error.role", "Role name must be unique");
            return "Roles/create";
        }

        return "redirect:/roles/";
    }

    @GetMapping("/edit/{id}")
    public String showEditRoleForm(@PathVariable("id") Long id, Model model) {
        ModelRole role = roleService.getRoleById(id);
        model.addAttribute("role", role);
        return "Roles/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateRole(@PathVariable("id") Long id, ModelRole role) {
        role.setIdRole(id);
        roleService.saveRole(role);
        return "redirect:/roles/";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable("id") Long id) {
        roleService.deleteRole(id);
        return "redirect:/roles/";
    }

    @GetMapping("/show/{id}")
    public String showRoleDetails(@PathVariable("id") Long id, Model model) {
        ModelRole role = roleService.getRoleById(id);
        model.addAttribute("role", role);
        return "Roles/show";
    }

}
