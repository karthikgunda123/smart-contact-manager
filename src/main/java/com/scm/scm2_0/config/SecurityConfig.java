package com.scm.scm2_0.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    // User create and login using java code with in memory service

//    private InMemoryUserDetailsManager inMemoryUserDetailsManager;
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails userDetails = User
//                .withDefaultPasswordEncoder()
//                .username("admin123")
//                .password("admin123")
//                .roles("ADMIN", "USER")
//                .build();
//
//        UserDetails userDetails1 = User
//                .withDefaultPasswordEncoder()
//                .username("karthik")
//                .password("karthik@123")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails, userDetails1);
//    }
}
