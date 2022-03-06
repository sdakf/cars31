package com.example.carsapp.users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String surname;
    private String password;
    private String login;

    public static User create(UserDto userDto) {
        User user = new User();
        user.firstName = userDto.getFirstName();
        user.surname = userDto.getSurname();
        user.password = userDto.getPassword();
        user.login = userDto.getLogin();
        return user;
    }

    public UserDto toDto() {
        return new UserDto(id, firstName, surname, null, login);
    }
}
