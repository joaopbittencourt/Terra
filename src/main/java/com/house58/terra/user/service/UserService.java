package com.house58.terra.user.service;

import com.house58.terra.config.UserPrincipal;
import com.house58.terra.user.dao.UserRepository;
import com.house58.terra.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User syncUser(Jwt jwt) {
        String id = jwt.getClaimAsString("sub");

        return userRepository.findById(UUID.fromString(id)).orElseGet(() -> {
            // Se não existe, cria a representação local com dados do Token
            User newUser = new User();
            newUser.setKeycloakId(id);
            newUser.setEmail(jwt.getClaimAsString("email"));
            newUser.setName(jwt.getClaimAsString("name"));
            return userRepository.save(newUser);
        });
    }
}
