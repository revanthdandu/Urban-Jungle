package com.example.UJ.UrbanJungle.controllers;

import com.example.UJ.UrbanJungle.model.GResponse;
import com.example.UJ.UrbanJungle.model.User;
import com.example.UJ.UrbanJungle.model.UserLoginResponse;
import com.example.UJ.UrbanJungle.security.JwtHelper;
import com.example.UJ.UrbanJungle.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")

public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtHelper jwtHelper;

    private UserDetails userDetails;


    @GetMapping()
    public String welcome(){
        return "welcome";
    }

//    @GetMapping("/user")
//    public Object user(Principal principal){
//        System.out.println("username: " + principal.getName());
//        return principal;
//    }

//    @GetMapping("/user")
//    public User users(@AuthenticationPrincipal OAuth2User user){
//        Map<String, Object> usered = user.getAttributes();
//        User cuser = new User();
//        cuser.setEmail(usered.get("email").toString());
//        cuser.setName(usered.get("given_name").toString());
//        cuser.setFullname(usered.get("name").toString());
//        return cuser;
//    }


//    @GetMapping("/user")
//    public Object users(@AuthenticationPrincipal OAuth2User user){
//        return user.getAuthorities();
//    }

//    @GetMapping("/user")
//    public String users(@AuthenticationPrincipal OAuth2User user){
//        System.out.println("entered");
//        Map<String, Object> usered = user.getAttributes();
//        User cuser = new User();
//        cuser.setEmail(usered.get("email").toString());
//        cuser.setName(usered.get("given_name").toString());
//        cuser.setFullname(usered.get("name").toString());
//        System.out.println("got all details");
//        return userService.create(cuser);
//    }

    @GetMapping("/user/hello")
    public String Hello(){
        return "Hello";
    }

    @PostMapping("/login")
    public UserLoginResponse Login(@RequestBody GResponse request) {
        UserLoginResponse userResponse = new UserLoginResponse();
        userResponse.setFullname("Revanth Dandu");
        userResponse.setLoginStatus("Logged in");
        return userResponse;
    }


//    http://localhost:8080/auth/login
}
