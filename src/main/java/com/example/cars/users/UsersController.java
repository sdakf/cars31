package com.example.cars.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    UserRepository userRepository = new UserRepository();
    UserRegistrationService registrationService = new UserRegistrationService(userRepository);
    UserLoginService loginService = new UserLoginService(userRepository);

    @PostMapping("/register")
    public void register(){
    }

    @PostMapping("/login")
    public void login(){
    }

}
