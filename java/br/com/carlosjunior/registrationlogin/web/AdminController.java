package br.com.carlosjunior.registrationlogin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @GetMapping("/admin-login")
    public String showLoginForm() {
        return "adminlogin";
    }

    @PostMapping("/admin-login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if (username.equals("admin") && password.equals("password")) {
            // Login successful, redirect to admin dashboard
            return "redirect:/admin-dashboard";
        } else {
            // Login failed, display error message
            model.addAttribute("error", "Invalid username or password");
            return "adminlogin";
        }
    }

    @GetMapping("/admin-dashboard")
    public String showDashboard() {
        // Return the admin dashboard page
        return "admin-dashboard";
    }
   
}
