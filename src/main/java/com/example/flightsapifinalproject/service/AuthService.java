package com.example.blogfinalproject2024.service;

import com.example.blogfinalproject2024.dto.UserRequestDTO;
import com.example.blogfinalproject2024.dto.UserResponseDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    UserResponseDTO register(UserRequestDTO dto);

}
