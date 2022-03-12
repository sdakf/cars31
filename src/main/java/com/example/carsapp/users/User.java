package com.example.carsapp.users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String surname;
    private String password;
    private String login;

    @ManyToMany
    @JoinTable(name = "Users_Roles",
            joinColumns = @JoinColumn(name = "u_id"),
            inverseJoinColumns = @JoinColumn(name = "r_id"))
    private List<UserRole> userRoles;

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
