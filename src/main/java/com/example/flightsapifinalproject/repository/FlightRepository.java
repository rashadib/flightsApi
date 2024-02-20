package com.example.flightsapifinalproject.repository;

import com.example.flightsapifinalproject.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Flight,Long> {
}