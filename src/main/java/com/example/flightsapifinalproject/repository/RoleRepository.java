package com.example.blogfinalproject2024.repository;

import com.example.blogfinalproject2024.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByNameIgnoreCase(String roleName);
}