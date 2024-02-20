package com.example.flightsapifinalproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //AUTO_INCREMENT
    private Long id;
    @NotNull
    private String origin;
    @NotNull
    private String destination;
    @NotNull
    private Date date;
}
