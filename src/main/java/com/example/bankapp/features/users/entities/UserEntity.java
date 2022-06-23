package com.example.bankapp.features.users.entities;

import com.example.bankapp.features.roles.entities.RoleEntity;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "app_user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String login;
    @Column
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;
}
