package com.example.bankapp.features.users.services;

import com.example.bankapp.features.users.entities.UserEntity;

public interface UserService {
    UserEntity saveUser(UserEntity userEntity);
    UserEntity findByLogin(String login);
    UserEntity findByLoginAndPassword(String login, String password);

}
