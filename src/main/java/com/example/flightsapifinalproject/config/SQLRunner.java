package com.example.blogfinalproject2024.config;

import com.example.blogfinalproject2024.entity.Role;
import com.example.blogfinalproject2024.entity.User;
import com.example.blogfinalproject2024.repository.RoleRepository;
import com.example.blogfinalproject2024.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class SQLRunner implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            var adminRole = roleRepository.save(new Role(1L, "ROLE_ADMIN"));
            var userRole = roleRepository.save(new Role(2L, "ROLE_USER"));

            userRepository.save(
                    new User(
                            1L,
                            "admin",
                            "tomerbu@gmail.com",
                            passwordEncoder.encode("password1!P"),
                            Set.of(adminRole),
                            Set.of()
                    )
            );

            userRepository.save(

                    new User(
                            2L,
                            "user",
                            "moe@gmail.com",
                            passwordEncoder.encode("password1!P"),
                            Set.of(userRole),
                            Set.of()
                    )
            );
        }
    }
}
