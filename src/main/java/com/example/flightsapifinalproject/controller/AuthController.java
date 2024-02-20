package com.example.blogfinalproject2024.controller;

import com.example.blogfinalproject2024.dto.UserRequestDTO;
import com.example.blogfinalproject2024.dto.UserResponseDTO;
import com.example.blogfinalproject2024.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid UserRequestDTO dto, UriComponentsBuilder uriBuilder) {
        return ResponseEntity.created(uriBuilder.path("/login").build().toUri()).body(authService.register(dto));
    }

    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> userDetails(Authentication authentication) {

        System.out.println(authentication);

        return ResponseEntity.ok(
                Map.of(
                        "username", authentication.getName(),
                        "authorities",authentication.getAuthorities()
                )
        );

    }
}