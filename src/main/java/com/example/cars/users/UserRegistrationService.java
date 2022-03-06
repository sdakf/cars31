package com.example.cars.users;

import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    UserRepository userRepository;

    public UserRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    void register() {
        userRepository.save();
    }
}
