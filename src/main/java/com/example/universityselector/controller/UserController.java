package com.example.universityselector.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.universityselector.entity.User;
import com.example.universityselector.service.UserService;

@Controller
@RequestMapping("/register")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegistrationForm(Model model) {
    	System.out.println("Sachin is tring to register a new user from showRegistrationForm method");
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute User user, Model model) {
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            logger.error("Error occurred while registering user", e);
            model.addAttribute("errorMessage", "An error occurred while registering. Please try again.");
            return "register";
        }
        System.out.println("Sachin is being redirected to login page");
        return "redirect:/login";
    }
}
