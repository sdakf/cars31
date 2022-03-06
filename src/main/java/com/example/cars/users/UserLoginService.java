package com.example.cars.users;

public class UserLoginService {

    UserRepository userRepository;

    public UserLoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    void login() {
        userRepository.find();
    }
}
