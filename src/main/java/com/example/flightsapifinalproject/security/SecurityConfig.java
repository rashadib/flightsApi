package com.example.blogfinalproject2024.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final PasswordEncoder passwordEncoder;
    @Bean
    public InMemoryUserDetailsManager userDetails() {
        return new InMemoryUserDetailsManager(
                User.withUsername("user")
                        .password(passwordEncoder.encode("password"))
                        .authorities("ROLE_USER")
                        .build(),
                User.withUsername("admin")
                        .password(passwordEncoder.encode("password"))
                        .authorities("ROLE_ADMIN")
                        .build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth -> {
                            //allow AuthController login/register
                            auth.requestMatchers("/api/v1/auth/**").permitAll();

                            //secure the rest of the API
                            auth.requestMatchers("/api/v1/**").authenticated();

                            //  permit any request that does not start with /api/v1
                            auth.anyRequest().permitAll(); //docs  //swagger
                        }
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .httpBasic(withDefaults())
                .build();
    }

}