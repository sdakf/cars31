package com.example.cars.users;

import com.example.cars.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> fetchUsers() {
        return userRepository.findAll().stream()
                .map(user -> user.toDto())
                .collect(Collectors.toList());
    }

    public UserDto fetchUsersById(Long id) {
        return userRepository.findById(id)
                .map(user -> user.toDto())
                .orElseThrow(()->new RuntimeException());
    }

    public UserDto createUser(UserDto userDto) {
        User user = User.create(userDto);
        User saved = userRepository.save(user);
        return saved.toDto();
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        user.setFirstName(userDto.getFirstName());
        user.setSurname(userDto.getSurname());
        user.setLogin(user.getLogin());
        user.setPassword(user.getPassword());
        User saved = userRepository.save(user);
        return saved.toDto();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
