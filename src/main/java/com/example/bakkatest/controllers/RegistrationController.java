package com.example.bakkatest.controllers;

import com.example.bakkatest.DAO.UserRepository;
import com.example.bakkatest.entities.Role;
import com.example.bakkatest.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;


@Controller
public class RegistrationController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public  String addUser(User user, Model model){
        if (repository.checkPassword(user.getLogin())!=null){
            model.addAttribute("message","User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        repository.addUser(user);

        return "redirect:/login";
    }

}
