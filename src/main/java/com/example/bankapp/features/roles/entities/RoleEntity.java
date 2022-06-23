package com.example.bankapp.features.roles.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "role")
@Data
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
}
