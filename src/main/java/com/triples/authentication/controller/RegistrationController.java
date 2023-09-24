package com.triples.authentication.controller;

import com.triples.authentication.dto.UserDto;
import com.triples.authentication.entities.User;
import com.triples.authentication.model.UserRegistration;
import com.triples.authentication.services.RegistrationService;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/create-user")
    @Logger
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        // Register the user
        boolean success = registrationService.registerUser(userDto);
        if (success) {
            return ResponseEntity.ok("User registered successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to register user");
        }
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userRegistration", new UserRegistration());
        // You can also add roles to the model if needed
        // model.addAttribute("roles", rolesList);
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("userRegistration") UserRegistration userRegistration) {
        // Handle form submission and registration logic here
        return "login"; // Redirect to a success page
    }

    @RequestMapping("/login")
    public String login() {
        return "login"; // This returns the view name (registration.html)
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
