package com.example.carsapp.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override//to jest konfiguracja sposobu logowania użytkownika
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Adam").password("Adam_pass").roles("USER");

    }

    @Override//to jest konfiguracja blokowanych zasobów
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers("/cars", "/cars/**").authenticated()
                .anyRequest().permitAll() //dostep maja wszyscy wszedzie
                .and()
                .httpBasic(); //wlaczenie autentykacji przy pomocy headera Authorization Basic


    }
}
