package com.example.carsapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    @Override//to jest konfiguracja sposobu logowania użytkownika
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("Adam")
//                .password(passwordEncoder.encode("Adam_pass"))
//                .roles("USER");
        auth.jdbcAuthentication()
                .usersByUsernameQuery(
                        "select u.login, u.password, 1 from users u where u.login = ?"
                )
                .authoritiesByUsernameQuery(
                        "select u.login,r.role_name from Users u " +
                                "join Users_Roles u_r on u.id = u_r.u_id " +
                                "join Roles r on u_r.r_id = r.id " +
                                "where u.login = ?"
                )
                .passwordEncoder(passwordEncoder)
                .dataSource(dataSource);
    }

    @Override//to jest konfiguracja blokowanych zasobów
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers("/cars", "/cars/**").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/h2-console").permitAll()
                .anyRequest().permitAll() //dostep maja wszyscy wszedzie
                .and()
                .httpBasic(); //wlaczenie autentykacji przy pomocy headera Authorization Basic

        http.headers().frameOptions().disable();

    }
}
