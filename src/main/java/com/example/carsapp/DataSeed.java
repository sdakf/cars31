package com.example.carsapp;

import com.example.carsapp.cars.Car;
import com.example.carsapp.cars.CarRepository;
import com.example.carsapp.options.CarOption;
import com.example.carsapp.options.OptionsRepository;
import com.example.carsapp.users.User;
import com.example.carsapp.users.UserRepository;
import com.example.carsapp.users.UserRole;
import com.example.carsapp.users.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class DataSeed {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OptionsRepository optionsRepository;

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

        Car audi = new Car(null, user, "Audi A3", 0L, Collections.emptyList(), BigDecimal.ZERO);
        Car bmw = new Car(null, user, "Bmw M2", 0L, Collections.emptyList(), BigDecimal.ZERO);
        carRepository.save(audi);
        carRepository.save(bmw);

        CarOption carOption1 = new CarOption(null, "Radyjko", "k001");
        CarOption carOption2 = new CarOption(null, "Dywaniki", "k002");
        CarOption carOption3 = new CarOption(null, "Zasłonki", "k003");

        optionsRepository.save(carOption1);
        optionsRepository.save(carOption2);
        optionsRepository.save(carOption3);
    }

}
