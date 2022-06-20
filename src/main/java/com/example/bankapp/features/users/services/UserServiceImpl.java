package com.example.bankapp.features.users.services;

import com.example.bankapp.features.roles.entities.RoleEntity;
import com.example.bankapp.features.roles.repositories.RoleRepository;
import com.example.bankapp.features.users.entities.UserEntity;
import com.example.bankapp.features.users.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        RoleEntity roleEntity = roleRepository.findByName("ROLE_USER");
        userEntity.setRoleEntity(roleEntity);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);

    }

    @Override
    public UserEntity findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public UserEntity findByLoginAndPassword(String login, String password) {
        UserEntity userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
}
