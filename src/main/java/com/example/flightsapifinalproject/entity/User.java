package com.example.blogfinalproject2024.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "UQ_USER_NAME", columnNames = {"username"})
})
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2)
    private String username;
    @NotNull
    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            )},
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Role> roles;

}
