package com.example.carsapp;

import com.example.carsapp.users.User;
import com.example.carsapp.users.UserRepository;
import com.example.carsapp.users.UserRole;
import com.example.carsapp.users.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class DataSeed {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @PostConstruct
    public void postConstruct() {
        UserRole userAccess = new UserRole("USER");
        UserRole adminAccess = new UserRole("ADMIN");
        UserRole savedUserAccess = userRoleRepository.save(userAccess);
        UserRole savedAdminAccess = userRoleRepository.save(adminAccess);

        User user = new User();
        user.setFirstName("Ewa");
        user.setSurname("Kowalski");
        user.setLogin("Ewa");
        user.setUserRoles(List.of(savedUserAccess));
        user.setPassword(passwordEncoder.encode("Ewa_password"));
        userRepository.save(user);



    }

}
