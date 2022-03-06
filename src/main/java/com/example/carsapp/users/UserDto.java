package com.example.carsapp.users;

import lombok.Getter;

@Getter
public class UserDto {
    private Long id;
    private String firstName;
    private String surname;
    private String password;
    private String login;

    public UserDto(Long id, String firstName, String surname, String password, String login) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.password = password;
        this.login = login;
    }

    public UserDto() {

    }
}
