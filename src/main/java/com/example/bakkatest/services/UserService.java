package com.example.bakkatest.services;


import com.example.bakkatest.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends com.example.bakkatest.services.Service {
    public String getFullnameOfCurrentUser(){
        User user = findCurrenUser();
        return user.getFullname();
    }

    public void deleteCurrentUser(){
        userRepository.deleteUser(findCurrenUser());
    }


}
