package com.house58.terra.user.controller;

import com.house58.terra.user.dao.UserRepository;
import com.house58.terra.user.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController("user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    private User save(@RequestBody User user){
        return this.userRepository.save(user);
    }
    @PutMapping
    private User update(@RequestBody User user){
        return this.userRepository.save(user);
    }
    @DeleteMapping
    private User delete(@RequestBody User user){
        user.setStatus(false);
        return this.userRepository.save(user);
    }

}
