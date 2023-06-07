package com.absenceManager.ensah.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "registration/login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpServletRequest request, RedirectAttributes redirectAttributes) {

        // Usually, you let Spring Security handle the post login, this is just an example
        try {
            request.login(username, password);
        } catch (ServletException e) {
            redirectAttributes.addFlashAttribute("error", "Invalid username or password");
            return "redirect:/login";
        }
        return "redirect:/";
    }
}

