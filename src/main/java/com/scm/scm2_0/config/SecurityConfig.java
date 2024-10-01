package com.scm.scm2_0.config;

import com.scm.scm2_0.services.impl.SecurityCustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    @Autowired
    private SecurityCustomUserDetailService userDetailService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        // User Details Service ka object
        daoAuthenticationProvider.setUserDetailsService(userDetailService);

        // Password Encoder ka object
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
