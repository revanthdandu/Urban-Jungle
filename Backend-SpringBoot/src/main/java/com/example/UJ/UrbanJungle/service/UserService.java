package com.example.UJ.UrbanJungle.service;

import com.example.UJ.UrbanJungle.model.User;
import com.example.UJ.UrbanJungle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String create(User cuser){

        userRepository.save(cuser);
        return "OK";
    }
}
