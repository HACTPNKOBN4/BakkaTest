package com.example.bakkatest.controllers;

import com.example.bakkatest.DAO.UserRepository;
import com.example.bakkatest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserService us;

    @GetMapping("/profile")
    public String profile(Model model){
        String fullname = us.getFullnameOfCurrentUser();

        model.addAttribute("fullname",fullname);
        return "user-profile";
    }

    @PostMapping("/delete")
    public String deleteProfile(){
        us.deleteCurrentUser();
        return "login";
    }
}
