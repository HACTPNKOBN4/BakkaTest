package com.example.bakkatest.services;

import com.example.bakkatest.DAO.BakkaRepository;
import com.example.bakkatest.DAO.UserRepository;
import com.example.bakkatest.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public class Service {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected BakkaRepository bakkaRepository;



    protected User findCurrenUser(){
        return userRepository.findByLogin(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName()
        );
    }
}
