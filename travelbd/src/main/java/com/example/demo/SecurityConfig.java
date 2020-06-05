package com.example.demo;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Asus on 05-Jun-20.
 */

// class to override the default spring security login page
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//         http
//                 .authorizeRequests()
//                 .anyRequest().authenticated()
//                 .and()
//                 .formLogin()
//                 .loginPage("/login")
//                 .permitAll();
//    }
}
